package com.todo_be.todo_be.controller;

import com.todo_be.todo_be.service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/password")
@RequiredArgsConstructor
public class ForgotPasswordController {
    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        passwordResetService.requestPasswordReset(email);
        return "Password reset link has been sent if the email exists.";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestBody Map<String, String> request) {
        String newPassword = request.get("password");
        boolean success = passwordResetService.resetPassword(token, newPassword);
        return success ? "Password reset successful." : "Invalid token.";
    }
}