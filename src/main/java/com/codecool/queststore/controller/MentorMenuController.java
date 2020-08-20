package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

import java.util.ArrayList;
import java.util.List;

public class MentorMenuController extends MenuController {

    SessionController sessionController;

    public MentorMenuController(User loggedUser, View view, UserDao userDao, SessionController sessionController) {
        super(loggedUser, view, userDao);
        this.sessionController = sessionController;
        createMainMenuMap();
    }

    public void displayAllStudents() {
        userDao.requestDataFromDB("SELECT id, first_name, last_name, email FROM users WHERE role_id = 3");
    }

    private void createMainMenuMap() {
        mainMenuMap.put("1", this::displayAllStudents);
        //mainMenuMap.put("2", this::addStudent); //TO DO
        mainMenuMap.put("3", this::editStudent);
        //mainMenuMap.put("4", this::addQuest); //TO DO
        //mainMenuMap.put("5", this::checkQuest);   // TO DO
        //mainMenuMap.put("6", this::editQuest);   // TO DO
        //mainMenuMap.put("7", this::addReward);   // TO DO
        //mainMenuMap.put("8", this::editReward);   // TO DO
        //mainMenuMap.put("9", this::seeWallets);   // TO DO
        mainMenuMap.put("10", this::initializeGetAllQuests);   // TO DO
    }

    private void initializeGetAllQuests() {
        List<Quest> quests = sessionController.getQuestDao().getAllQuests();
        prepareToPrintData(quests);


    }

    private void prepareToPrintData(List<Quest> quests) {
        List<String> toPrint = new ArrayList<>();
        for (Quest quest : quests) {
            toPrint.add(quest.getId() + ", " + quest.getName() + ", " + quest.getDescription() + ", " + quest.getCoinsToEarn() + ", " + quest.getModuleId());
        }
        sessionController.getView().printStringList(toPrint);
    }

    private void editStudent() {
        int role = Role.STUDENT.getRoleId();
        String roleString = String.valueOf(role);
        userDao.createPrintQueryUserTable("*", "role_id = " + roleString);
        getUserEditInfo();

    }
}
