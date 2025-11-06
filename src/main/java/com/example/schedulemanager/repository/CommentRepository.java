package com.example.schedulemanager.repository;

import com.example.schedulemanager.entity.Comment;
import com.example.schedulemanager.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countBySchedule(Schedule schedule);

    List<Comment> findBySchedule(Schedule schedule);

    void deleteBySchedule(Schedule schedule);
}
