package com.example.firstspringproject.controller;

import com.example.firstspringproject.dao.CarsDAO;
import com.example.firstspringproject.models.Cars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<Cars> all = carsDAO.findAll();
        return all;
    }
@PostMapping("/postcar")
    public void postCar(@RequestBody Cars car){
    System.out.println(car);
    carsDAO.save(car);
}
}
