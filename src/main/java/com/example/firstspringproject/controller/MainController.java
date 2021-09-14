package com.example.firstspringproject.controller;

import com.example.firstspringproject.dao.CarsDAO;
import com.example.firstspringproject.models.Cars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private CarsDAO carsDAO;

    public MainController(CarsDAO carsDAO) {
        this.carsDAO = carsDAO;
    }

    @GetMapping("/getcars")
    public List<Cars> cars() {
        List all = carsDAO.findAll();
        return all;
    }

}
