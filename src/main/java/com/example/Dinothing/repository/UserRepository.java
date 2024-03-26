package com.example.Dinothing.repository;

import com.example.Dinothing.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);
    Optional<UserEntity> findByEmail(String email);
}
