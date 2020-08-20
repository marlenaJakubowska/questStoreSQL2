package com.codecool.queststore.model.users;

import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.Reward;

import java.util.List;

public abstract class User {
    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean isActive;
    private String login;
    private String password;



    public User(int id, String firstName, String lastName,
                Role role, boolean isActive, String login, String password
                ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.isActive = isActive;
        this.login = login;
        this.password = password;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
