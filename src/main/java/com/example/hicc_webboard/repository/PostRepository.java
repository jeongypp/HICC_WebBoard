package com.example.hicc_webboard.repository;

import com.example.hicc_webboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 상속 -> 기본 CRUD 메서드 자동 생성
public interface PostRepository extends JpaRepository<Post, Long> {
}