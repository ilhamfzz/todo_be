package com.todo_be.todo_be.service;

import java.util.List;

import com.todo_be.todo_be.request.TodoRequest;
import com.todo_be.todo_be.response.BaseResponse;
import com.todo_be.todo_be.response.TodoResponse;

public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse getTodoById(Long id);
    BaseResponse createTodo(TodoRequest todo);
    BaseResponse updateTodo(TodoRequest todo, Long id);
    BaseResponse deleteTodo(Long id);
}
