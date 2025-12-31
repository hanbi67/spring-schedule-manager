package com.example.schedulemanager.repository;

import com.example.schedulemanager.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByScheduleId(Long scheduleId);
}
