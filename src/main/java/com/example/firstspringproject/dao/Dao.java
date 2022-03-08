package com.example.firstspringproject.dao;

import com.example.firstspringproject.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dao extends JpaRepository<Player, Integer> {
}