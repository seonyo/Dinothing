package com.example.Dinothing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteIdeaDto {
    private Long userId;
    private Long ideaId;
}
