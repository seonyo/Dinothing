package com.example.Dinothing.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteHeartRequestDto {
    private Long ideaId;
    private Long userId;

}
