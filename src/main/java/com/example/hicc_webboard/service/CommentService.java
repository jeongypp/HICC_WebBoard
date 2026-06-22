package com.example.hicc_webboard.service;

import com.example.hicc_webboard.dto.CommentListResponse;
import com.example.hicc_webboard.dto.CommentRequest;
import com.example.hicc_webboard.dto.CommentResponse;
import com.example.hicc_webboard.dto.MessageResponse;
import com.example.hicc_webboard.entity.Comment;
import com.example.hicc_webboard.entity.Post;
import com.example.hicc_webboard.exception.PostNotFoundException;
import com.example.hicc_webboard.repository.CommentRepository;
import com.example.hicc_webboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 4. 특정 게시글의 댓글 조회
    public CommentListResponse getComments(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException();
        }

        List<CommentResponse> comments = commentRepository.findByPostId(postId).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());

        return new CommentListResponse(comments);
    }

    // 5. 특정 게시글에 댓글 작성
    public MessageResponse createComment(Long postId, CommentRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException());

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);

        commentRepository.save(comment);

        return new MessageResponse("성공적으로 등록됐습니다.");
    }
}