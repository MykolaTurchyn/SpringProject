package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDAO;
import com.example.firstspringproject.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class MainController {

    private UserDAO userDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        System.out.println("got users");
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable int id) {
//        User byId = userDao.getById(id);
        User byId = userDao.findById(id).orElse(new User(0, null, 0));
        System.out.println("got user by id");
        return byId;
    }

    @PostMapping("/addUser")
    public List<User> saveUser(@RequestBody User user) {
        userDao.save(user);
        return userDao.findAll();
    }
    @DeleteMapping("/users/delete/{id}")
    public List deleteById(@PathVariable int id) {
        userDao.deleteById(id);
        return userDao.findAll();
    }
    @DeleteMapping("/users/deleteAll")
    public List deleteAll() {
        userDao.deleteAll();
        return userDao.findAll();
    }
}
