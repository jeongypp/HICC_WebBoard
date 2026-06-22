package com.example.hicc_webboard.controller;

import com.example.hicc_webboard.dto.MessageResponse;
import com.example.hicc_webboard.dto.PostListResponse;
import com.example.hicc_webboard.dto.PostRequest;
import com.example.hicc_webboard.dto.PostResponse;
import com.example.hicc_webboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 1. 게시글 전체 조회 API (GET /api/posts)
    @GetMapping
    public ResponseEntity<PostListResponse> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // 2. 게시글 작성 API (POST /api/posts)
    @PostMapping
    public ResponseEntity<MessageResponse> createPost(@RequestBody PostRequest request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    // 3. 게시글 개별 조회 API (GET /api/posts/{post_id})
    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("post_id") Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }
}