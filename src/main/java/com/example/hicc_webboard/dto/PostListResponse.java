package com.example.hicc_webboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

// "posts": [ {..}, {..} ] 형태의 응답 DTO 레퍼
@Getter
@AllArgsConstructor
public class PostListResponse {
    private List<PostResponse> posts;
}