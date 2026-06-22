package com.example.hicc_webboard.service;

import com.example.hicc_webboard.dto.MessageResponse;
import com.example.hicc_webboard.dto.PostListResponse;
import com.example.hicc_webboard.dto.PostRequest;
import com.example.hicc_webboard.dto.PostResponse;
import com.example.hicc_webboard.entity.Post;
import com.example.hicc_webboard.exception.PostNotFoundException;
import com.example.hicc_webboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 1. 게시글 전체 조회
    public PostListResponse getAllPosts() {
        List<PostResponse> posts = postRepository.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
        return new PostListResponse(posts);
    }

    // 2. 게시글 작성
    public MessageResponse createPost(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        postRepository.save(post);

        return new MessageResponse("성공적으로 등록됐습니다.");
    }

    // 3. 게시글 개별 조회
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException()); // 게시글이 없으면 예외 발생

        return new PostResponse(post);
    }
}