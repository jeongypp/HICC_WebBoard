package com.example.hicc_webboard.controller;

import com.example.hicc_webboard.dto.CommentListResponse;
import com.example.hicc_webboard.dto.CommentRequest;
import com.example.hicc_webboard.dto.MessageResponse;
import com.example.hicc_webboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/{post_id}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 4. 댓글 조회 API (GET /api/posts/{post_id}/comment)
    @GetMapping
    public ResponseEntity<CommentListResponse> getComments(@PathVariable("post_id") Long postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    // 5. 댓글 작성 API (POST /api/posts/{post_id}/comment)
    @PostMapping
    public ResponseEntity<MessageResponse> createComment(
            @PathVariable("post_id") Long postId,
            @RequestBody CommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(postId, request));
    }
}