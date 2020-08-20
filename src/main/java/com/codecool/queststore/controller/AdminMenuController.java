package com.codecool.queststore.controller;

import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class AdminMenuController extends MenuController {
    public AdminMenuController(User loggedUser, View view) {
        super(loggedUser, view);
    }
}
