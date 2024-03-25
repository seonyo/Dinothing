package com.example.Dinothing.repository;

import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
    Optional<IdeaEntity> findById(long userId);
}
