package com.example.firstspringproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class MainController {
     @GetMapping("/")
         public String start () {
             return "server work"  ;
         }

}
