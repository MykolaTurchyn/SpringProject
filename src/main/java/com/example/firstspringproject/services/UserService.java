package com.example.firstspringproject.services;

import com.example.firstspringproject.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String tokenazer(User user) {
        return "tokenshomokenuser" + user.getLogin() + user.getId();
    }
}
