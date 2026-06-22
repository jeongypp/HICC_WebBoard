package com.example.hicc_webboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// "성공적으로 등록됐습니다." 메시지 반환용 JSON
@Getter
@AllArgsConstructor
public class MessageResponse {
    private String message;
}