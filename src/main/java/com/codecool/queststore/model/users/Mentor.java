package com.codecool.queststore.model.users;

public class Mentor extends User{
    public Mentor(int id, String firstName, String lastName, Role role, boolean isActive, String login, String password) {
        super(id, firstName, lastName, role, isActive, login, password);
    }
}
