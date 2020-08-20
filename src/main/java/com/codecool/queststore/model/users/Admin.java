package com.codecool.queststore.model.users;

public class Admin extends User{
    public Admin(int id, String firstName, String lastName, Role role, boolean isActive, String login, String password) {
        super(id, firstName, lastName, role, isActive, login, password);
    }
}
