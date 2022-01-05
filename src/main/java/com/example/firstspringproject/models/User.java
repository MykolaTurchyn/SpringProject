package com.example.firstspringproject.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private User_Type type;

    public User(String name, String first_name, String last_name, String email, String password) {
        this.username = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String first_name, String last_name, String email, String password, User_Type type) {
        this.username = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }
    public void setName(String name) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
//        if (!getEmail().contains("@gmail.com")) {
//            System.out.println("SORRY YOUR EMAIL IS INVALID");
//        }
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
//        if (getPassword().matches("[a-zA-Z0-9]")) {
//            return ("SORRY,PASSWORD MUST BE LONGER THAN 8 CHARACTERS");
//        } else if (getPassword().length() >= 8) {
//            return ("SORRY,the password must contain a number, lowercase and uppercase!");
//        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_Type getType() {
        return type;
    }

    public void setType(User_Type type) {
        this.type = type;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return type == user.type;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}