package com.example.memo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddMemoRequest {
    @NotEmpty(message = "내용은 필수입니다.")
    @Size(max = 255)
    private String content;
}