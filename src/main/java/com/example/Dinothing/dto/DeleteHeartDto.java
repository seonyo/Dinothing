package com.example.Dinothing.dto;

import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteHeartDto {
    private Long ideaId;
    private Long userId;

}
