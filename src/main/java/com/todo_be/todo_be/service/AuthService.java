package com.todo_be.todo_be.service;

import org.springframework.stereotype.Service;

import com.todo_be.todo_be.request.AuthRequest;
import com.todo_be.todo_be.request.RegisterRequest;
import com.todo_be.todo_be.response.AuthResponse;

@Service
public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}