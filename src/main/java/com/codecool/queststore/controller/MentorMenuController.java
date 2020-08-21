package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.Category;
import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.Reward;
import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.Student;
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
        mainMenuMap.put("2", this::addStudent);
        mainMenuMap.put("3", this::editStudent);
        mainMenuMap.put("4", this::addQuest);
        //mainMenuMap.put("5", this::checkQuest);   // TO DO
        //mainMenuMap.put("6", this::editQuest);   // TO DO
        mainMenuMap.put("7", this::addReward);   // TO DO
        //mainMenuMap.put("8", this::editReward);   // TO DO
        //mainMenuMap.put("9", this::seeWallets);   // TO DO
        mainMenuMap.put("10", this::initializeGetAllQuests);   // TO DO
    }
//    public Reward(int id, String name, String description, int price, Category category, int mentorId) {

    private void addReward() {
        Reward reward = new Reward(
                1,
                sessionController.getInputProvider().takeUserInput("Reward name: "),
                sessionController.getInputProvider().takeUserInput("Reward description: "),
                sessionController.getInputProvider().getNumberFromUser("Reward price: "),
                Category.valueOf(sessionController.getInputProvider().getNumberFromUser("Category Id (1 - 2): ")),
                sessionController.getInputProvider().getNumberFromUser("Mentory Id: ")
                );
        sessionController.getRewardDao().add(reward);
    }
//    public Quest(int id, String name, String description, int coinsToEarn, int moduleId) {

    private void addQuest() {
        Quest quest = new Quest(
                1,
                sessionController.getInputProvider().takeUserInput("Quest name: "),
                sessionController.getInputProvider().takeUserInput("Quest description: "),
                sessionController.getInputProvider().getNumberFromUser("Reward (coins): "),
                sessionController.getInputProvider().getNumberFromUser("Module id: ")
        );
        sessionController.getQuestDao().add(quest);
    }

    private void addStudent() {
        User student = new Student(
                1,
                sessionController.getInputProvider().takeUserInput("Student first name: "),
                sessionController.getInputProvider().takeUserInput("Student last name: "),
                Role.STUDENT,
                false,
                sessionController.getInputProvider().takeUserInput("Student login: "),
                sessionController.getInputProvider().takeUserInput("Student password: ")
        );
        int isActiveNumber = sessionController.getInputProvider().getNumberFromUser("Is Student active? (1 - yes, 2 - no)");
        boolean isActive = isActiveNumber == 1;
        student.setActive(isActive);
        userDao.add(student);
    }

//    private void initializeGetAllQuests() {
//        List<Quest> quests = sessionController.getQuestDao().getAllQuests();
//        prepareToPrintData(quests);
//    }

    private void initializeGetAllQuests() {
        userDao.requestDataFromDB("SELECT * FROM quests;");
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
