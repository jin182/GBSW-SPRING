package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.dto.AddMemoRequest;
import com.example.memo.dto.MemoResponse;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public List<MemoResponse> getMemos() {
        return memoRepository.findAll()
                .stream()
                .map(MemoResponse::new)
                .collect(Collectors.toList());
    }

    public MemoResponse addMemo(AddMemoRequest request) {
        Memo memo = new Memo();
        memo.setContent(request.getContent());
        memo.setCreatedAt(LocalDateTime.now());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoResponse(savedMemo);
    }
}