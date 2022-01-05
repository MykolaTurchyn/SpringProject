package com.example.firstspringproject.controllers;

import com.example.firstspringproject.models.User;
import com.example.firstspringproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:3000"})

public class MainController {

    private UserService userService;

    @GetMapping("/get_all")
    public List<User> all() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.addUser(user);
    }

    @PatchMapping("/update")
    public List<User> update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public List<User> deleteOne(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @DeleteMapping("/delete_all")
    public List<User> deleteAll() {
        return userService.deleteAllUsers();
    }
}
