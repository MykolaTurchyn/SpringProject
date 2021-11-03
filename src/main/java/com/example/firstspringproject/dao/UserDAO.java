package com.example.firstspringproject.dao;

import com.example.firstspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findUserByLoginAndPassword(String login, String password);
}
