package com.codecool.queststore.controller;
import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class AdminMenuController extends MenuController {

    private final UserDao userDao; //testing

    public AdminMenuController(User loggedUser, View view) {
        super(loggedUser, view);
        createMainMenuMap();
        this.userDao = new UserDao(); //testing
    }

    private void createMainMenuMap() {
        //mainMenuMap.put("1", this::addMentor); //To do
        //mainMenuMap.put("2", this::editMentor); //To do
        //mainMenuMap.put("3", this::addClass); //To do
        //mainMenuMap.put("4", this::showMentorProfile); //to do
        mainMenuMap.put("5", this::displayAllUsers);
    }

    private void displayAllUsers() {
        userDao.displayAllUsers();
    }

}
