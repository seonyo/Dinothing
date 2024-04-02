package com.example.Dinothing.controller;

import com.example.Dinothing.dto.MemoDto;
import com.example.Dinothing.entity.MemoEntity;
import com.example.Dinothing.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memos")
public class MemoController {
    private MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService){
        this.memoService = memoService;
    }
    @PostMapping
    public ResponseEntity<String> createMemo(@RequestBody MemoDto request){
        MemoEntity memos = memoService.createOrUpdateMemo(request);
        return ResponseEntity.ok().body("memo 변경 성공했습니다");
    }

}
