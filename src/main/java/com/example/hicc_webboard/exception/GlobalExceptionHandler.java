package com.example.hicc_webboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// App 전역에서 발생하는 예외를 감지 및 처리하는 어노테이션.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // PostNotFoundException 발생 시 실행
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(PostNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), // 404
                "POST_NOT_FOUND",
                ex.getMessage()
        );

        // 404 Not Found 와 함께 DTO 반환.
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}