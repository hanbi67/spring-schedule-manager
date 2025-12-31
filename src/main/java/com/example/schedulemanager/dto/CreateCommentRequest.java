package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String contents;
    private String authorName;
    private String password;
}
