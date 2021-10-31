package com.example.firstspringproject.controllers;

import com.example.firstspringproject.DAO.SkillDAO;
import com.example.firstspringproject.DAO.UserDAO;
import com.example.firstspringproject.models.Skill;
import com.example.firstspringproject.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class MainController {
    private UserDAO UserDao;
    private SkillDAO SkillDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        return UserDao.findAll();
    }

    @PostMapping("/user")
    public List<User> addUser(@RequestBody User user) {
//        public List<User> saveUserWithSkill(User user) {
        UserDao.save(user);
        List<Skill> skills = user.getSkills();
        for (Skill skill : skills) {
            skill.setUser(user);
            SkillDao.save(skill);
        }
        return UserDao.findAll();
    }
}
