package com.example.hicc_webboard.dto;

import com.example.hicc_webboard.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

// 클라이언트에게 댓글 정보 반환 시 사용하는 DTO
@Getter
public class CommentResponse {
    private final Long id;
    private final String content;

    @JsonProperty("create_date")
    private String createDate;

    private final Long post;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createDate = comment.getCreateDate().toString();
        this.post = comment.getPost().getId();
    }
}