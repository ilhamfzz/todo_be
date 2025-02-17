package com.todo_be.todo_be.service;

import java.util.List;

import com.todo_be.todo_be.request.TodoRequest;
import com.todo_be.todo_be.response.TodoResponse;

public interface TodoService {
    List<TodoResponse> getAllTodos() throws Exception;
    TodoResponse getTodoById(Long id) throws Exception;
    String createTodo(TodoRequest todo) throws Exception;
    String updateTodo(TodoRequest todo, Long id) throws Exception;
    String deleteTodo(Long id) throws Exception;
}
