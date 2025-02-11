package com.todo_be.todo_be.service;

public interface PasswordResetService {
    void requestPasswordReset(String email);
    boolean resetPassword(String token, String newPassword);
}
