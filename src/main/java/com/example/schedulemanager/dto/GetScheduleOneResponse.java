package com.example.schedulemanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetScheduleOneResponse {
    //Response에서 password 제외해 반환
    //일정 선택 조회용 + 댓글 목록 조회 DTO
    private final Long id;
    private final String title;
    private final String contents;
    private final String authorName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // 일정에 달린 댓글 목록 (password 제외)
    private final List<GetCommentResponse> comments;

    public GetScheduleOneResponse(Long id, String title, String contents, String authorName, LocalDateTime createdAt, LocalDateTime modifiedAt, List<GetCommentResponse> comments) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
    }
}
