package com.example.Dinothing.repository;

import com.example.Dinothing.entity.IdeaEntity;
import com.example.Dinothing.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
    UserEntity findById(long userId);

}
