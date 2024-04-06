package com.example.Dinothing.service;

import com.example.Dinothing.dto.user.LoginRequestDto;
import com.example.Dinothing.dto.user.PasswordUpdateRequestDto;
import com.example.Dinothing.dto.user.RegisterRequestDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.exception.EmailDuplicateException;
import com.example.Dinothing.exception.EmailNotFoundException;
import com.example.Dinothing.exception.PasswordNotFoundException;
import com.example.Dinothing.exception.error.ErrorCode;
import com.example.Dinothing.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity registerUser(RegisterRequestDto request) {
        String nickname = request.getNickname();
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());

        duplicatedEmail(email);

        return userRepository.save(request.toEntity(password));
    }

    public void duplicatedEmail(String email){
        if(userRepository.existsByEmail(email)) {
            throw new EmailDuplicateException("email duplicated", ErrorCode.EMAIL_DUPLICATION);
        }
    }

    public long loginUser(LoginRequestDto request, HttpServletRequest httpRequest){
        String email = request.getEmail();
        String password = request.getPassword();

        checkEmail(email);

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new RuntimeException("User not found"));

        checkPassword(password, userEntity.getPassword());

        HttpSession session = httpRequest.getSession(true);
        session.setAttribute("userId", userEntity.getId());

        return userEntityOptional.get().getId();
    }

    public void checkEmail(String email){
        if(!userRepository.existsByEmail(email)) {
            throw new EmailNotFoundException("email not found", ErrorCode.EMAIL_NOTFOUND);
        }
    }

    private void checkPassword(String password, String hashedPassword){
        if(!passwordEncoder.matches(password, hashedPassword)) {
            throw new PasswordNotFoundException("Invalid password", ErrorCode.PASSWORD_NOTFOUND);
        }
    }

    public UserEntity passwordUpdate(PasswordUpdateRequestDto request){
        String email = request.getEmail();
        String password = request.getPassword();

        checkEmail(email);

        Optional<UserEntity> UserEntity = userRepository.findByEmail(email);

        UserEntity user = UserEntity.get();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

}
