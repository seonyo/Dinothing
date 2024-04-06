package com.example.Dinothing.dto.Response;

import lombok.*;

@Getter
public class UserIdResponseDto {
    private final Long id;

    public UserIdResponseDto (Long user){
        this.id = user;
    }

}
