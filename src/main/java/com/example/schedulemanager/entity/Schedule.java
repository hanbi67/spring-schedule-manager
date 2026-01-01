package com.example.schedulemanager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    //일정 생성 시, 포함되어야할 데이터
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String contents;
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    private String password;

    //생성자
    public Schedule(String title, String contents, String authorName, String password) {
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
        this.password = password;
    }

    //setter - update
    public void update(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

}
