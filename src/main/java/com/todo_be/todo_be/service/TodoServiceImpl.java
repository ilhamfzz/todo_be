package com.todo_be.todo_be.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.todo_be.todo_be.entity.Todo;
import com.todo_be.todo_be.repository.TodoRepository;
import com.todo_be.todo_be.request.TodoRequest;
import com.todo_be.todo_be.response.BaseResponse;
import com.todo_be.todo_be.response.TodoResponse;
import com.todo_be.todo_be.response.UserResponse;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final UserService userService;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        UserResponse user = userService.getMyProfile();
        List<Todo> todos = todoRepository.getTodosByUserId(Long.valueOf(user.getId()));
        return todos.stream().map(TodoResponse::new).collect(Collectors.toList());
    }

    @Override
    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.getTodoById(id);
        UserResponse user = userService.getMyProfile();
        if (!todo.getUserId().equals(Long.valueOf(user.getId()))) {
            throw new BadCredentialsException("Unauthorized access");
        }
        return new TodoResponse(todo);
    }

    @Override
    public BaseResponse createTodo(TodoRequest todo) {
        LocalDateTime now = LocalDateTime.now();
        Timestamp sqlNow = Timestamp.valueOf(now);
        UserResponse user = userService.getMyProfile();
        Todo newTodo = new Todo();
        newTodo.setUserId(Long.valueOf(user.getId()));
        newTodo.setTitle(todo.getTitle());
        newTodo.setDescription(todo.getDescription());
        newTodo.setIsCompleted(todo.getIsCompleted());
        newTodo.setCreatedAt(sqlNow);
        newTodo.setUpdatedAt(sqlNow);
        newTodo.setIsDeleted(false);
        todoRepository.save(newTodo);
        return new BaseResponse("Todo created successfully");
    }

    @Override
    public BaseResponse updateTodo(TodoRequest todo, Long id) {
        Todo updatedTodo = todoRepository.getTodoById(id);
        UserResponse user = userService.getMyProfile();
        if (!updatedTodo.getUserId().equals(Long.valueOf(user.getId()))) {
            throw new BadCredentialsException("Unauthorized access");
        }
        updatedTodo.setTitle(todo.getTitle());
        updatedTodo.setDescription(todo.getDescription());
        updatedTodo.setIsCompleted(todo.getIsCompleted());
        updatedTodo.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        todoRepository.save(updatedTodo);
        return new BaseResponse("Todo updated successfully");
    }

    @Override
    public BaseResponse deleteTodo(Long id) {
        Todo deletedTodo = todoRepository.getTodoById(id);
        UserResponse user = userService.getMyProfile();
        if (!deletedTodo.getUserId().equals(Long.valueOf(user.getId()))) {
            throw new BadCredentialsException("Unauthorized access");
        }
        deletedTodo.setIsDeleted(true);
        todoRepository.save(deletedTodo);
        return new BaseResponse("Todo deleted successfully");
    }
}
