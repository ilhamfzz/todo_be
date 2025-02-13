package com.todo_be.todo_be.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.todo_be.todo_be.entity.Todo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    // @JsonProperty("name")
    // private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("is_completed")
    private Boolean isCompleted;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.userId = todo.getUserId();
        // this.name = todo.getName();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.isCompleted = todo.getIsCompleted() == 1 ? true : false;
        this.createdAt = todo.getCreatedAt().toString();
        this.updatedAt = todo.getUpdatedAt().toString();
        this.isDeleted = todo.getIsDeleted() == 1 ? true : false;
    }
}
