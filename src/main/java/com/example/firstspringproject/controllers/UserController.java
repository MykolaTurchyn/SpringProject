package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDAO;
import com.example.firstspringproject.models.User;
import com.example.firstspringproject.services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserDAO userDao;
    private MailService mailService;

    @PostMapping("/register")
    public String register(@RequestBody User user) throws MessagingException {
        userDao.save(user);
        mailService.sender(user.getLogin(), user.getId());
        return "register";
    }

    @GetMapping("/activate/{id}")
    public String activate(@PathVariable int id) {
        User user = userDao.findById(id).get();
        user.setActivate(true);
        userDao.save(user);
        return "User " + id + " activated";
    }
}
