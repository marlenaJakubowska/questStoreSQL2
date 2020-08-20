package com.codecool.queststore.controller;

import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class MentorMenuController extends MenuController {
    public MentorMenuController(User loggedUser, View view) {
        super(loggedUser, view);
        createMainMenuMap();
    }

    private void createMainMenuMap() {
        mainMenuMap.put("1", this::displayAllStudents);
        //mainMenuMap.put("2", this::addStudent); //TO DO
        //mainMenuMap.put("3", this::editStudent); //TO DO
        //mainMenuMap.put("4", this::addQuest); //TO DO
        //mainMenuMap.put("5", this::checkQuest);   // TO DO
        //mainMenuMap.put("6", this::editQuest);   // TO DO
        //mainMenuMap.put("7", this::addReward);   // TO DO
        //mainMenuMap.put("8", this::editReward);   // TO DO
        //mainMenuMap.put("9", this::seeWallets);   // TO DO
    }
}
