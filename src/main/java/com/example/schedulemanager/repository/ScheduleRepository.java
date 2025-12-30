package com.example.schedulemanager.repository;

import com.example.schedulemanager.entity.Schedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByAuthorName(String authorName, Sort sort);
}
