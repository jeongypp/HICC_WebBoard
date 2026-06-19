package com.example.hicc_webboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목 길이 제한, 최대 30글자
    @Column(length = 30, nullable = false)
    private String title;

    // 글 내용 TEXT 타입 사용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // create_date
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDate createDate;

    // 게시글 삭제 시 달린 댓글도 함께 삭제되도록
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    // 엔티티가 데이터베이스에 처음 저장되기 전에 실행
    @PrePersist
    public void prePersist() {
        this.createDate = LocalDate.now();
    }
}