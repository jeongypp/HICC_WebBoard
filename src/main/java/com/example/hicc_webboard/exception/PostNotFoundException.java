package com.example.hicc_webboard.exception;

// 게시글을 찾지 못했을 때 발생하는 예외 처리 클래스
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super("존재하지 않는 게시글입니다.");
    }
}