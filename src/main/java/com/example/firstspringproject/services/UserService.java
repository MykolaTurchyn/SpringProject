package com.example.firstspringproject.services;

import com.example.firstspringproject.dao.UserDAO;
import com.example.firstspringproject.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void addUser(User user) {
//        boolean hasSpecial = user.getPassword().matches("0-9");
//        if (user.getPassword().length() >= 8) {
//            System.out.println("Password must have 8 characters or more");
//        } else if(!hasSpecial){
//            System.out.println("must have special character");
//        }else
            userDAO.save(user);
    }

    public List<User> updateUser(User user) {
        userDAO.save(user);
        return userDAO.findAll();
    }

    public List<User> deleteUser(int id) {
        userDAO.deleteById(id);
        return userDAO.findAll();
    }

    public List<User> deleteAllUsers() {
        userDAO.deleteAll();
        return userDAO.findAll();
    }

}
