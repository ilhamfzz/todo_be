package com.todo_be.todo_be.service;

import com.todo_be.todo_be.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
    void sendResetEmail(String to, String token);
}
