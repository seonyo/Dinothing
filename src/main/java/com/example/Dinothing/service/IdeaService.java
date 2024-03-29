package com.example.Dinothing.service;

import com.example.Dinothing.dto.IdeaDto;
import com.example.Dinothing.dto.IdeaUpdateDto;
import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.repository.IdeaRepository;
import com.example.Dinothing.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IdeaService {
    private final IdeaRepository ideaRepository;
    private final UserRepository userRepository;

    public IdeaEntity createIdea(IdeaDto request){
        Long userId = request.getUserId().getId();
        // existsBy : 존재하는지 안하는지 확인해주는거 존재하면 true, 아니면 false -> !를 붙였으니까 존재안하면 try catch 하는거
        if(!userRepository.existsById(userId)) throw new EntityNotFoundException("User not found with id: " + userId);

        return ideaRepository.save(request.toEntity());
    }

    public List<IdeaEntity> getUserIdea(long userId){
        return ideaRepository.findAllByUserId(userId);
    }

    public IdeaEntity getUserIdeaById(long userId, long ideaId) {
        return ideaRepository.findByUserIdAndId(userId, ideaId);
    }

    public IdeaEntity updateIdea(Long userId, Long ideaId, IdeaUpdateDto request){
        IdeaEntity idea = ideaRepository.findByUserIdAndId(userId, ideaId);

        idea.setQ1(request.getQ1());
        idea.setQ2(request.getQ2());
        idea.setQ3(request.getQ3());
        idea.setQ4(request.getQ4());
        idea.setQ5(request.getQ5());
        idea.setQ6(request.getQ6());
        idea.setQ7(request.getQ7());
        idea.setProgress(request.getProgress());

        return ideaRepository.save(idea);
    }
}
