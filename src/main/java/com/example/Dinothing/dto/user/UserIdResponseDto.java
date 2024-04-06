package com.example.Dinothing.dto.user;

import lombok.*;

@Getter
public class UserIdResponseDto {
    private final Long id;

    public UserIdResponseDto (Long user){
        this.id = user;
    }

}
