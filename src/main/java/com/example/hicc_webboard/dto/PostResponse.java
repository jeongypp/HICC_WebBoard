package com.example.hicc_webboard.dto;

import com.example.hicc_webboard.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

// 클라이언트에게 게시글 정보 반환 시 사용되는 DTO
@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;

    @JsonProperty("create_date")
    private String createDate;

    // 생성자 (엔티티를 DTO로 변환)
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createDate = post.getCreateDate().toString();
    }
}