package com.todo_be.todo_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_be.todo_be.config.JwtService;
import com.todo_be.todo_be.entity.User;
import com.todo_be.todo_be.repository.UserRepository;
import com.todo_be.todo_be.response.UserResponse;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    private HttpServletRequest request;
    private UserRepository userRepository;
    private JwtService jwtService;
    
    @Autowired
    public UserServiceImpl(HttpServletRequest request, UserRepository userRepository, JwtService jwtService) {
        this.request = request;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public UserResponse getMyProfile() {
        String token = jwtService.getToken(request);
        String userEmail = jwtService.extractUsername(token);
        User user = userRepository.findDataByEmail(userEmail);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return new UserResponse(user);
    }
}
