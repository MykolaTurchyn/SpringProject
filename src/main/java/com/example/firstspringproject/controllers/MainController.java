package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.userDAO;
import com.example.firstspringproject.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@Data
public class MainController {

    private userDAO userDao;

    @GetMapping("/")
    public String start() {
        return "server work";
    }

    @GetMapping("/get_users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @PostMapping("/add_user")
    public String add(@RequestBody User user) {
        userDao.save(user);
        return "OK";
    }

}
