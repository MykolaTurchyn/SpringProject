package com.example.firstspringproject.DAO;

import com.example.firstspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
