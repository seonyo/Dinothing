package com.example.Dinothing.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteIdeaRequestDto {
    private Long userId;
    private Long ideaId;
}
