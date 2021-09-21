package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDAO;
import com.example.firstspringproject.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class MainController {
    private UserDAO userDAO;

    public MainController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public List<User> users() {
        List<User> all = userDAO.findAll();
        return all;
    }

    @PostMapping("/users")
    public void adduser(@RequestBody User user) {
        userDAO.save(user);
//        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteuser(@PathVariable int id) {
        userDAO.deleteById(id);
    }

}