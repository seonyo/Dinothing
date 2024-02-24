package com.example.Dinothing.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Data
public class UserDto {
    private String nickname;
    private String email;
    private String password;
}
