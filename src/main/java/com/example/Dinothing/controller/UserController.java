package com.example.Dinothing.controller;

import com.example.Dinothing.dto.UserDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody UserDto request){
        String nickname = request.getNickname();
        String email = request.getEmail();
        String password = request.getPassword();

        //이메일 등록되어있는지 확인
        if(userRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 이메일 입니다.");
        }
        //사용자 저장
        userRepository.save(UserEntity.builder().nickname(nickname).email(email).password(password).build());
        //성공 메세지
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공했습니다.");
    }
}
