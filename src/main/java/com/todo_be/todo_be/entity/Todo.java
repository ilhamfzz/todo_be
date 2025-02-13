package com.todo_be.todo_be.entity;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(name = "is_completed", nullable = false)
    private Integer isCompleted;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "is_deleted")
    private Integer isDeleted;

    public Todo() {
    }

    public Todo(Long id,Long userId, String title, String description, Integer isCompleted, Timestamp createdAt, Timestamp updatedAt, Integer isDeleted) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }
}
