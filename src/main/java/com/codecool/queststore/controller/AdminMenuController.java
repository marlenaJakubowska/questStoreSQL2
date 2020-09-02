package com.codecool.queststore.controller;
import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.users.Mentor;
import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.Student;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

public class AdminMenuController extends MenuController {

    SessionController sessionController;

    public AdminMenuController(User loggedUser, View view, UserDao userDao, SessionController sessionController) {
        super(loggedUser, view, userDao);
        createMainMenuMap();
        this.sessionController = sessionController;
    }

    private void createMainMenuMap() {
        mainMenuMap.put("1", this::addMentor);
        mainMenuMap.put("2", this::editMentor); //To do
        //mainMenuMap.put("3", this::addClass); //To do
        //mainMenuMap.put("4", this::showMentorProfile); //to do
        mainMenuMap.put("5", this::displayAllUsers);
    }
//    public Mentor(int id, String firstName, String lastName, Role role, boolean isActive, String login, String password) {

    private void addMentor() {
        User mentor = new Mentor(
                1,
                sessionController.getInputProvider().takeUserInput("Mentor first name: "),
                sessionController.getInputProvider().takeUserInput("Mentor last name: "),
                Role.MENTOR,
                false,
                sessionController.getInputProvider().takeUserInput("Mentor login: "),
                sessionController.getInputProvider().takeUserInput("Mentor password: ")
        );
        int isActiveNumber = sessionController.getInputProvider().getNumberFromUser("Is Mentor active? (1 - yes, 2 - no)");
        boolean isActive = isActiveNumber == 1;
        mentor.setActive(isActive);
        userDao.add(mentor);
    }

    public void editMentor() {
        int role = Role.MENTOR.getRoleId();
        String roleString = String.valueOf(role);
//        userDao.createPrintQueryUserTable("*", "role_id = " + roleString);
        getUserEditInfo();
    }

    private void displayAllUsers() {
//        userDao.displayAllUsers();
    }

}
