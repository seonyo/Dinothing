package com.example.Dinothing.service;

import com.example.Dinothing.dto.memo.MemoRequestDto;
import com.example.Dinothing.entity.MemoEntity;
import com.example.Dinothing.repository.MemoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;
    public MemoEntity createOrUpdateMemo(MemoRequestDto request){
        Optional<MemoEntity> optionalMemo = memoRepository.findById(request.getUserId().getId());

        MemoEntity memo = optionalMemo.orElseGet(MemoEntity::new);

        memo.setContent(request.getContent());

        return memoRepository.save(memo);
    }
}
