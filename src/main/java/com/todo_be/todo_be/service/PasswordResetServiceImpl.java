package com.todo_be.todo_be.service;

import com.todo_be.todo_be.entity.User;
import com.todo_be.todo_be.repository.UserRepository;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetServiceImpl implements PasswordResetService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String requestPasswordReset(String email) throws BadRequestException {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (!userOpt.isPresent()) {
            throw new BadRequestException("Email not registered");
        }

        User user = userOpt.get();
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        userRepository.save(user);
        emailService.sendResetEmail(email, token);
        return "Password reset email sent";
    }

    public String resetPassword(String token, String newPassword) throws BadRequestException {
        Optional<User> userOpt = userRepository.findByResetToken(token);
        if (!userOpt.isPresent()) {
            throw new BadRequestException("Invalid token");
        }
        User user = userOpt.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null);
        userRepository.save(user);
        return "Password reset successfully";
    }
}
