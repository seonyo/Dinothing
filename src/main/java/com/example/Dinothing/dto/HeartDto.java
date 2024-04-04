package com.example.Dinothing.dto;

import com.example.Dinothing.entity.HeartEntity;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HeartDto {
    private IdeaEntity ideaId;
    private UserEntity userId;

    public HeartEntity toEntity() {
        return HeartEntity.builder()
                .idea(ideaId)
                .user(userId)
                .build();
    }
}
