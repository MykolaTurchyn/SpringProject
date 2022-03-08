package com.example.firstspringproject.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Address address;
    private String created;
    private Player player;

    public Team() {
    }

    public Team(int id, String name, Address address, String created, Player player) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.created = created;
        this.player = player;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", created='" + created + '\'' +
                ", player=" + player +
                '}';
    }
}
