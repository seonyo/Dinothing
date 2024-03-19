package com.example.Dinothing.controller;

import com.example.Dinothing.dto.IdeaDto;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.service.IdeaService;
import com.example.Dinothing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ideas")
public class IdeaController {
    private IdeaService ideaService;
    @Autowired
    public IdeaController(IdeaService ideaService){
        this.ideaService = ideaService;
    }
    @PostMapping()
    public ResponseEntity<String> createIdea(@RequestBody IdeaDto request){
        IdeaEntity ideas = ideaService.createIdea(request);
        return ResponseEntity.ok().body("idea 등록 성공했습니다");
    }
}
