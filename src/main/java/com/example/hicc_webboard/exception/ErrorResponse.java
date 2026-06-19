package com.example.hicc_webboard.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

// 에러 응답 DTO
@Getter
@AllArgsConstructor
public class ErrorResponse {

    // JSON으로 변환될 때 키 값을 "status_code"로 강제 매핑
    @JsonProperty("status_code")
    private int statusCode;

    private String error;
    private String message;
}