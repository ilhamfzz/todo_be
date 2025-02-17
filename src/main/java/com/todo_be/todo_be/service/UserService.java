package com.todo_be.todo_be.service;

import com.todo_be.todo_be.response.UserResponse;

public interface UserService {
    UserResponse getMyProfile() throws Exception;
}
