package com.todo_be.todo_be.service;

public interface PasswordResetService {
    String requestPasswordReset(String email) throws Exception;
    String resetPassword(String token, String newPassword) throws Exception;
}
