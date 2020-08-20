package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class StudentMenuController extends MenuController {

    public StudentMenuController(User loggedUser, View view, UserDao userDao) {
        super(loggedUser, view, userDao);
        createMainMenuMap();
    }

    private void createMainMenuMap() {
        //mainMenuMap.put("1", this::showWallet); //TO DO
        //mainMenuMap.put("2", this::buyArtifact); //TO DO
        //mainMenuMap.put("3", this::buyArtifactWithSomeone); //TO DO
        //mainMenuMap.put("4", this::showMyLevel); //TO DO
    }
}
