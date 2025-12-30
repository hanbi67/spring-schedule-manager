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
    private String title;
    private String contents;
    private String authorName;
    private String password;

    //생성자
    public Schedule(String title, String contents, String authorName, String password) {
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
        this.password = password;
    }

    //setter - update
    public void update(String title, String contents, String authorName, String password) {
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
        this.password = password;
    }

}
