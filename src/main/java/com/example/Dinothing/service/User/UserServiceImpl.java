package com.example.Dinothing.service.User;

import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(RegisterDto request) {
        String nickname = request.getNickname();
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());

        if(userRepository.existsByEmail(email)) {
            return false;
        }

        userRepository.save(UserEntity.builder().nickname(nickname).email(email).password(password).build());
        return true;
    }
}
