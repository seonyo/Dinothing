package com.example.Dinothing.dto;

import com.example.Dinothing.entity.MemoEntity;
import com.example.Dinothing.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemoRequestDto {
    private UserEntity userId;
    private String content;


    public MemoEntity toEntity() {
        MemoEntity memoEntity = new MemoEntity();
        memoEntity.setUser(userId);
        memoEntity.setContent(content);
        return memoEntity;
    }
}
