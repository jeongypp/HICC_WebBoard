package com.example.hicc_webboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 클라이언트에서 게시글 작성시 보내는 데이터 DTO
@Getter
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String content;
}