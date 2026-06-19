package com.example.hicc_webboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 길이 제한, 최대 200글자
    @Column(length = 200, nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDate createDate;

    // N:1 관계, 댓글 : 게시글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // 엔티티가 데이터베이스에 처음 저장되기 전에 실행
    @PrePersist
    public void prePersist() {
        this.createDate = LocalDate.now();
    }
}