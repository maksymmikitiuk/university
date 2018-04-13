package com.maksymmikitiuk.university.service.email;

import org.springframework.mail.SimpleMailMessage;

import java.util.Map;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMessageUsingTemplate(String to, String subject, Map model, String template);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}