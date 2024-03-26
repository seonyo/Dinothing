package com.example.Dinothing.controller;

import com.example.Dinothing.dto.IdeaDto;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.repository.IdeaRepository;
import com.example.Dinothing.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ideas")
public class IdeaController {
    private IdeaService     ideaService;
    private IdeaRepository ideaRepository;
    @Autowired
    public IdeaController(IdeaService ideaService, IdeaRepository ideaRepository){
        this.ideaService = ideaService;
        this.ideaRepository = ideaRepository;
    }
    @PostMapping()
    public ResponseEntity<String> createIdea(@RequestBody IdeaDto request){
        IdeaEntity ideas = ideaService.createIdea(request);
        return ResponseEntity.ok().body("idea 등록 성공했습니다");
    }
    @GetMapping("/{id}")
    public List<IdeaEntity> getUserIdea(@PathVariable("id") long id){
        List<IdeaEntity> ideas = ideaService.getUserIdea(id);
        return ideas;
    }
}
