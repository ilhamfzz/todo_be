package com.todo_be.todo_be.service;

public interface PasswordResetService {
    String requestPasswordReset(String email);
    String resetPassword(String token, String newPassword);
}
