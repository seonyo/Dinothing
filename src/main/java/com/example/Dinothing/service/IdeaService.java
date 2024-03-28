package com.example.Dinothing.service;

import com.example.Dinothing.dto.IdeaDto;
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

    public List<IdeaEntity> getUserIdeaById(long userId, long ideaId) {
        return ideaRepository.findByUserIdAndId(userId, ideaId);
    }
}
