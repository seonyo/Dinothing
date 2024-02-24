package com.example.Dinothing.controller;

import com.example.Dinothing.config.SecurityConfig;
import com.example.Dinothing.dto.UserDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody UserDto request){
        String nickname = request.getNickname();
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());

        if(userRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 이메일 입니다.");
        }

        userRepository.save(UserEntity.builder().nickname(nickname).email(email).password(password).build());

        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공했습니다.");
    }
}
