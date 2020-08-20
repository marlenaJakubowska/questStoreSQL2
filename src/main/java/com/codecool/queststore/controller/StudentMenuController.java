package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class StudentMenuController extends MenuController {

    private final UserDao userDao; //testing

    public StudentMenuController(User loggedUser, View view) {
        super(loggedUser, view);
        createMainMenuMap();
        this.userDao = new UserDao(); //testing
    }

    private void createMainMenuMap() {
        //mainMenuMap.put("1", this::showWallet); //TO DO
        //mainMenuMap.put("2", this::buyArtifact); //TO DO
        //mainMenuMap.put("3", this::buyArtifactWithSomeone); //TO DO
        //mainMenuMap.put("4", this::showMyLevel); //TO DO
    }
}
