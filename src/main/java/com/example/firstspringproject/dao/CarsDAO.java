package com.example.firstspringproject.dao;

import com.example.firstspringproject.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsDAO extends JpaRepository<Cars,Integer> {
}
