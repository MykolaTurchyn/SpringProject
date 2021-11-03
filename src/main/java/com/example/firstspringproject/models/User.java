package com.example.firstspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String login;
    private String password;
    private boolean isActivated;
    private String token;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
