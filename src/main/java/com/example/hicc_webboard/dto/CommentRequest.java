package com.example.hicc_webboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 클라이언트에서 댓글 작성 시 보내는 데이터 DTO
@Getter
@NoArgsConstructor
public class CommentRequest {
    private String content;
}