package com.example.schedulemanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentResponse {
    //Response에서 password 제외
    private final Long id;
    private final Long scheduleId;
    private final String contents;
    private final String authorName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateCommentResponse(Long id, Long scheduleId, String contents, String authorName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.contents = contents;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
