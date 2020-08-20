package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.view.View;

public class SessionController {

    public SessionController() {
        initialize();
    }

    public void initialize() {
        View view = new View();
        UserDao userDao = new UserDao();
        InputProvider inputProvider= new InputProvider();
        LoginController loginController = new LoginController(view, userDao, inputProvider);
    }
}
