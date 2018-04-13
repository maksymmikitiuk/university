package com.maksymmikitiuk.university.controller;

import com.maksymmikitiuk.university.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    private SpringTemplateEngine templateEngine;

//    @Autowired
//    public SimpleMailMessage template;

    @GetMapping(value = "send/{to}/{subject}/{text}")
    public @ResponseBody
    String createMail(@PathVariable("to") String to, @PathVariable("subject") String subject, @PathVariable("text") String text) {
        Map model = new HashMap();
        model.put("name", "Maksym");
        model.put("reset_code", "123456789");

        emailService.sendSimpleMessageUsingTemplate(to, subject, model, "reset_password");
        return "";
    }
}
