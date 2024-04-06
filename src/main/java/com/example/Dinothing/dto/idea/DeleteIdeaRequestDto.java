package com.example.Dinothing.dto.idea;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteIdeaRequestDto {
    private Long userId;
    private Long ideaId;
}
