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
    @GetMapping("/{id}")
    public List<IdeaEntity> getUserIdea(@PathVariable("id") Long id){
        return ideaService.getUserIdea(id);
    }

    @GetMapping("/{user_id}/{idea_id}")
    public List<IdeaEntity> getUserIdeaById (@PathVariable("user_id") Long user_id, @PathVariable("idea_id") Long idea_id){
        return ideaService.getUserIdeaById(user_id, idea_id);
    }
}
