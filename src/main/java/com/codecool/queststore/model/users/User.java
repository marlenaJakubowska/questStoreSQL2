package com.codecool.queststore.model.users;

import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.Reward;

import java.util.List;

public abstract class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Role role;
    private final String login;
    private final String password;
    private boolean isActive;

    public User(int id, String firstName, String lastName,
                Role role, String login, String password,
                boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.login = login;
        this.password = password;
        this.isActive = isActive;
    }
}
