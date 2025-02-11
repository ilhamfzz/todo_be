package com.todo_be.todo_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo_be.todo_be.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value = "SELECT * FROM todos WHERE is_deleted = false", nativeQuery = true)
    List<Todo> getAllTodos();

    @Query(value = "SELECT * FROM todos WHERE id = :id AND is_deleted = false", nativeQuery = true)
    Todo getTodoById(Long id);

    @Query(value = "SELECT * FROM todos WHERE user_id = :userId AND is_deleted = false", nativeQuery = true)
    List<Todo> getTodosByUserId(Long userId);
}
