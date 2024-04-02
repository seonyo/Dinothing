package com.example.Dinothing.repository;

import com.example.Dinothing.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long>  {
}
