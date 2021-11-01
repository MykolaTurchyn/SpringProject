package com.example.firstspringproject.services;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailService;

    @SneakyThrows
    public void sender(String email, int id) throws MessagingException {
        MimeMessage mimeMessage = javaMailService.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        mimeMessage.setFrom(new InternetAddress("testspring65@gmail.com"));
        helper.setTo(email);
        helper.setText("click <a href='http://localhost:8080/user/activate/" + id + "'>here</a> to activate", true);
        javaMailService.send(mimeMessage);
    }
}