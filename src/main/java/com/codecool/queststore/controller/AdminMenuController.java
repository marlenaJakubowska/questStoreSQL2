package com.codecool.queststore.controller;
import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.service.AdminService;
import com.codecool.queststore.view.View;

public class AdminMenuController extends MenuController {


    //for test
    InputProvider ip = new InputProvider();

    public AdminMenuController(User loggedUser, View view, UserDao userDao) {
        super(loggedUser, view, userDao);
        createMainMenuMap();
    }

    private void createMainMenuMap() {
        //mainMenuMap.put("1", this::addMentor); //To do
        mainMenuMap.put("2", this::editMentor); //To do
        mainMenuMap.put("3", this::editingMentorInADifferentWay); //To do


        //mainMenuMap.put("3", this::addClass); //To do
        //mainMenuMap.put("4", this::showMentorProfile); //to do
        mainMenuMap.put("5", this::displayAllUsers);
    }

    public void editMentor() {
        int role = Role.MENTOR.getRoleId();
        String roleString = String.valueOf(role);
        userDao.createPrintQueryUserTable("*", "role_id = " + roleString);
        getUserEditInfo();
    }

    private void displayAllUsers() {
        userDao.displayAllUsers();
    }

    //testinggggg

    private void editingMentorInADifferentWay() {
        int id = ip.getNumberFromUser("Enter id of a mentor: ");
        AdminService.updateMentorName(id);
    }

}
