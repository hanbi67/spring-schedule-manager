package com.example.schedulemanager.repository;

import com.example.schedulemanager.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByScheduleId(Long scheduleId);

    List<Comment> findByScheduleId(Long scheduleId);
}
