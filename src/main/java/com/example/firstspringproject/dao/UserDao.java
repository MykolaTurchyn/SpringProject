package com.example.firstspringproject.dao;

import com.example.firstspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
