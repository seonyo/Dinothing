package com.example.Dinothing.service;

import com.example.Dinothing.dto.IdeaDto;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.IdeaRepository;
import com.example.Dinothing.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class IdeaService {
    private IdeaRepository ideaRepository;
    private UserRepository userRepository;

    @Autowired
    public IdeaService(UserRepository userRepository, IdeaRepository ideaRepository){
        this.userRepository = userRepository;
        this.ideaRepository = ideaRepository;
    }

    public IdeaEntity createIdea(IdeaDto request){
        String q1 = request.getQ1();
        String q2 = request.getQ2();
        String q3 = request.getQ3();
        String q4 = request.getQ4();
        String q5 = request.getQ5();
        String q6 = request.getQ6();
        String q7 = request.getQ7();
        String color = request.getColor();
        long userId = request.getUserId();

        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

        // Optional에서 UserEntity를 가져옴
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return ideaRepository.save(IdeaEntity.builder().q1(q1).q2(q2).q3(q3).q4(q4).q5(q5).q6(q6).q7(q7).color(color).userId(userEntity).build());
    }

    public Optional<IdeaEntity> getUserIdea(long id){
        Optional<IdeaEntity> ideas = ideaRepository.findById(id);
        return ideas;
    }
}
