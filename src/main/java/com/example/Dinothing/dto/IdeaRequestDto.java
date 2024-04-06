package com.example.Dinothing.dto;

import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdeaRequestDto {

    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String color;
    private UserEntity userId;

    public IdeaEntity toEntity() {

        return IdeaEntity.builder()
                .q1(q1)
                .q2(q2)
                .q3(q3)
                .q4(q4)
                .q5(q5)
                .q6(q6)
                .q7(q7)
                .color(color)
                .progress(1)
                .user(userId)
                .build();
    }
}
