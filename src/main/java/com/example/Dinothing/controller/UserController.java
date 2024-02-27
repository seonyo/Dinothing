package com.example.Dinothing.controller;

import com.example.Dinothing.dto.LoginDto;
import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping()
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDto request) {
        UserEntity users = userService.registerUser(request);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("message", "회원가입에 성공했습니다.");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody LoginDto request){
        String email = request.getEmail();
        String password = request.getPassword();
        return null;
    }
}
