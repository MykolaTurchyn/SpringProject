package com.example.firstspringproject.models;

import com.example.firstspringproject.DAO.UserDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int exp;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Skill(String title, int exp) {
        this.title = title;
        this.exp = exp;
    }
}
