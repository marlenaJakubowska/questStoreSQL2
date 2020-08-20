package com.codecool.queststore.controller;

import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class MentorMenuController extends MenuController {
    public MentorMenuController(User loggedUser, View view) {
        super(loggedUser, view);
    }
}
