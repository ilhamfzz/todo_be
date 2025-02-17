package com.todo_be.todo_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo_be.todo_be.request.TodoRequest;
import com.todo_be.todo_be.response.BaseResponse;
import com.todo_be.todo_be.response.TodoResponse;
import com.todo_be.todo_be.service.TodoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() throws Exception {
        List<TodoResponse> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) throws Exception {
        TodoResponse todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createTodo(@RequestBody TodoRequest todo) throws Exception {
        String response = todoService.createTodo(todo);
        return ResponseEntity.ok(new BaseResponse(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> updateTodo(@RequestBody TodoRequest todo, @PathVariable Long id) throws Exception {
        String response = todoService.updateTodo(todo, id);
        return ResponseEntity.ok(new BaseResponse(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteTodo(@PathVariable Long id) throws Exception {
        String response = todoService.deleteTodo(id);
        return ResponseEntity.ok(new BaseResponse(response));
    }
}
