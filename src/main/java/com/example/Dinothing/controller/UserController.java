package com.example.Dinothing.controller;

import com.example.Dinothing.dto.LoginDto;
import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserEntity> registerUser(@RequestBody RegisterDto request) {
        UserEntity users = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody LoginDto request){
        String email = request.getEmail();
        String password = request.getPassword();
        return null;
    }
}
