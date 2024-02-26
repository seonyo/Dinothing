package com.example.Dinothing.controller;

import com.example.Dinothing.dto.LoginDto;
import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.UserRepository;
import com.example.Dinothing.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto request){
        if(userService.registerUser(request)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 이메일 입니다.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody LoginDto request){
        String email = request.getEmail();
        String password = request.getPassword();
        return null;
    }
}
