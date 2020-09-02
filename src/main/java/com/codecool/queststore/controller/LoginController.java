package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.model.users.*;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private final SessionController sessionController;

    public LoginController(SessionController sessionController){
        this.sessionController = sessionController;
    }

    public void init() {
        List<User> users = sessionController.getAllUsers();
        sessionController.getView().displayUsers(users);
//        sessionController.getUserDao().displayAllUsers(); //For presentation
        User user = logIn();
        setMenuController(user);
    }

    private User logIn() {
        User loggedUser;
        String email;
        do {
            email = sessionController.getInputProvider().takeUserInput("Email: ");
            String password = sessionController.getInputProvider().takeUserInput("Password: ");
            loggedUser = loginTry(email, password);
        } while (loggedUser == null);
        System.out.println("Logged in");
        setMenuController(loggedUser);
        return loggedUser;
    }

    private User loginTry(String email, String password) {
        List<User> users;
        users = getSameUser(email, password);
        return users.isEmpty() ? null : users.get(0);
    }

    private List<User> getSameUser(String email, String password) {
        return new ArrayList<>();
    }


    private void setMenuController(User loggedUser) {
        MenuController menuController;
        if (loggedUser instanceof Admin) {
            menuController = new AdminMenuController(loggedUser, sessionController.getView(), sessionController.getUserDao(), sessionController);
            menuController.handleMenu(menuController.getMainMenuMap(), sessionController.getView()::printAdminMenu);
        } else if(loggedUser instanceof Mentor){
            menuController = new MentorMenuController(loggedUser, sessionController.getView(), sessionController.getUserDao(), sessionController);
            menuController.handleMenu(menuController.getMainMenuMap(), sessionController.getView()::printMentorMenu);
        } else if(loggedUser instanceof Student) {
            menuController = new StudentMenuController(loggedUser, sessionController.getView(), sessionController.getUserDao());
            menuController.handleMenu(menuController.getMainMenuMap(), sessionController.getView()::printStudentMenu);
        }
    }
}
