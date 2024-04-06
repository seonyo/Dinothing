package com.example.Dinothing.controller;

import com.example.Dinothing.dto.idea.IdeaRequestDto;
import com.example.Dinothing.dto.idea.IdeaUpdateRequestDto;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideas")
public class IdeaController {
    private IdeaService ideaService;
    @Autowired
    public IdeaController(IdeaService ideaService){
        this.ideaService = ideaService;
    }
    @PostMapping
    public ResponseEntity<String> createIdea(@RequestBody IdeaRequestDto request){
        IdeaEntity ideas = ideaService.createIdea(request);
        return ResponseEntity.ok().body("idea 등록 성공했습니다");
    }
    @GetMapping("/{id}")
    public List<IdeaEntity> getUserIdea(@PathVariable("id") Long id){
        return ideaService.getUserIdea(id);
    }

    @GetMapping("/{user_id}/{idea_id}")
    public IdeaEntity getUserIdeaById (@PathVariable("user_id") Long user_id, @PathVariable("idea_id") Long idea_id){
        return ideaService.getUserIdeaById(user_id, idea_id);
    }

    @PutMapping
    public ResponseEntity<String> updateIdea (@RequestBody IdeaUpdateRequestDto request){
        ideaService.updateIdea(request.getUserId(), request.getIdeaId(), request);
        return  ResponseEntity.ok().body("idea 수정 성공했습니다");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteIdea (@RequestBody IdeaUpdateRequestDto request){
        ideaService.deleteIdea(request.getUserId(), request.getIdeaId());
        return ResponseEntity.ok().body("idea 삭제 성공했습니다");
    }
}
