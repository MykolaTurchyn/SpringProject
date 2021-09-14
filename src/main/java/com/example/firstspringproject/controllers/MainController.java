package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDao;
import com.example.firstspringproject.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class MainController {

    private UserDao userDao;

    public MainController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> user() {
        List<User> all = userDao.findAll();
        return all;
    }

    @PostMapping("/user")
    public void save(@RequestBody User user) {
        System.out.println(user);
        userDao.save(user);
    }
}
