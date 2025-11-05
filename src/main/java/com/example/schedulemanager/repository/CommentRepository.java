package com.example.schedulemanager.repository;

import com.example.schedulemanager.entity.Comment;
import com.example.schedulemanager.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countBySchedule(Schedule schedule);
}
