package com.todo_be.todo_be.service;

import java.util.List;

import com.todo_be.todo_be.request.TodoRequest;
import com.todo_be.todo_be.response.TodoResponse;

public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse getTodoById(Long id);
    String createTodo(TodoRequest todo);
    String updateTodo(TodoRequest todo, Long id);
    String deleteTodo(Long id);
}
