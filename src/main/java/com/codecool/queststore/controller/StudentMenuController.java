package com.codecool.queststore.controller;

import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class StudentMenuController extends MenuController {
    public StudentMenuController(User loggedUser, View view) {
        super(loggedUser, view);
    }
}
