package com.example.Dinothing.service;

import com.example.Dinothing.dto.LoginDto;
import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.exception.EmailDuplicateException;
import com.example.Dinothing.exception.EmailNotFoundException;
import com.example.Dinothing.exception.PasswordNotFoundException;
import com.example.Dinothing.exception.error.ErrorCode;
import com.example.Dinothing.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity registerUser(RegisterDto request) {
        String nickname = request.getNickname();
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());

        duplicatedEmail(email);

        return userRepository.save(UserEntity.builder().nickname(nickname).email(email).password(password).build());
    }

    public void duplicatedEmail(String email){
        if(userRepository.existsByEmail(email)) {
            throw new EmailDuplicateException("email duplicated", ErrorCode.EMAIL_DUPLICATION);
        }
    }

    public long loginUser(LoginDto request){
        String email = request.getEmail();
        String password = request.getPassword();

        checkEmail(email);
        checkPassword(password);

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        return userEntityOptional.get().getId();
    }

    public void checkEmail(String email){
        if(!userRepository.existsByEmail(email)) {
            throw new EmailNotFoundException("email not found", ErrorCode.EMAIL_NOTFOUND);
        }
    }

    public void checkPassword(String password){
        if(!userRepository.existsByPassword(password)){
            throw new PasswordNotFoundException("password not found", ErrorCode.PASSWORD_NOTFOUND);
        }
    }

}
