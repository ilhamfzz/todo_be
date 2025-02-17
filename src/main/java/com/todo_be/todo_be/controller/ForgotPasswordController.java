package com.todo_be.todo_be.controller;

import com.todo_be.todo_be.response.BaseResponse;
import com.todo_be.todo_be.service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/password")
@RequiredArgsConstructor
public class ForgotPasswordController {
    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public ResponseEntity<BaseResponse> forgotPassword(@RequestParam String email) throws Exception {
        String response = passwordResetService.requestPasswordReset(email);
        return ResponseEntity.ok(new BaseResponse(response));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<BaseResponse> resetPassword(@RequestParam String token, @RequestBody Map<String, String> request) throws Exception {
        String newPassword = request.get("password");
        String response = passwordResetService.resetPassword(token, newPassword);
        return ResponseEntity.ok(new BaseResponse(response));
    }
}