package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.Dao;
import com.example.firstspringproject.models.Team;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class MainController {
 @GetMapping("/getTeams")
 public List<Team> getUsers() {
     return Dao.findAll();
 }

}
