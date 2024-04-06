package com.example.Dinothing.repository;

import com.example.Dinothing.entity.HeartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<HeartEntity, Long> {
    Optional<HeartEntity> findByUserIdAndIdeaId(Long userId, Long ideaId);
    void deleteByUserIdAndIdeaId(Long userId, Long ideaId);
    List<HeartEntity> findAllByUserId(Long userId);
}
