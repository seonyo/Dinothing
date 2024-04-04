package com.example.Dinothing.controller;

import com.example.Dinothing.dto.HeartDto;
import com.example.Dinothing.entity.HeartEntity;
import com.example.Dinothing.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hearts")
public class HeartController {
    private final HeartService heartService;
    @Autowired
    public HeartController(HeartService heartService) {
        this.heartService = heartService;
    }

    @PostMapping
    public ResponseEntity<String> createHeart(@RequestBody HeartDto request){
        HeartEntity hearts = heartService.createHeart(request);
        return ResponseEntity.ok().body("heart 등록 성공했습니다");
    }
}
