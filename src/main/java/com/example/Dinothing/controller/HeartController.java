package com.example.Dinothing.controller;

import com.example.Dinothing.dto.heart.DeleteHeartRequestDto;
import com.example.Dinothing.dto.heart.HeartRequestDto;
import com.example.Dinothing.entity.HeartEntity;
import com.example.Dinothing.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hearts")
public class HeartController {
    private final HeartService heartService;
    @Autowired
    public HeartController(HeartService heartService) {
        this.heartService = heartService;
    }

    @PostMapping
    public ResponseEntity<String> createHeart(@RequestBody HeartRequestDto request){
        HeartEntity hearts = heartService.createHeart(request);
        return ResponseEntity.ok().body("heart 등록 성공했습니다");
    }

    @DeleteMapping
    ResponseEntity<String> deleteHeart(@RequestBody DeleteHeartRequestDto request){
        heartService.deleteHeart(request);
        return ResponseEntity.ok().body("heart 삭제 성공했습니다");
    }

    @GetMapping("/{user_id}")
    public List<HeartEntity> getHeartById (@PathVariable("user_id") Long userId){
        return heartService.getUserHeartById(userId);
    }
}
