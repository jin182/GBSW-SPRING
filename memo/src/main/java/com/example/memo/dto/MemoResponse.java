package com.example.memo.dto;

import com.example.memo.domain.Memo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MemoResponse {
    private Integer id;
    private String content;
    private LocalDateTime createdAt;

    public MemoResponse(Memo memo) {
        this.id = memo.getId();
        this.content = memo.getContent();
        this.createdAt = memo.getCreatedAt();
    }
}

