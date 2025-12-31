package com.example.schedulemanager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{
    //댓글 생성 시, 포함되어야할 데이터
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //FK 사용 X, 댓글을 생성할 일정의 id
    private Long scheduleId;
    private String contents;
    private String authorName;
    private String password;

    //생성자
    public Comment(Long scheduleId, String contents, String authorName, String password) {
        this.scheduleId = scheduleId;
        this.contents = contents;
        this.authorName = authorName;
        this.password = password;
    }
}
