package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDao;
import com.example.firstspringproject.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MainController {

    private UserDao userDao;

    public MainController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> user() {
        List<User> all = userDao.findAll();
        return all ;
    }
    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        System.out.println(user);
    }
}
