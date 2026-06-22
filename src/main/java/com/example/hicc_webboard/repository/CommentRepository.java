package com.example.hicc_webboard.repository;

import com.example.hicc_webboard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId); // 특정 게시글에 달린 댓글만 조회하기 위한 메서드
}