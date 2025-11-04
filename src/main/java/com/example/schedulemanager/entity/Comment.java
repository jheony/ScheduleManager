package com.example.schedulemanager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String content;

    @Column(length = 20)
    private String author;

    @Column(length = 20)
    private String password;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String content, String author, String password, Schedule schedule){
        this.content = content;
        this.author = author;
        this.password = password;
        this.schedule = schedule;
    }
}
