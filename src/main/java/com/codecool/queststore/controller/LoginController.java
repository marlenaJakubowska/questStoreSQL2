package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.*;
import com.codecool.queststore.service.QuestService;
import com.codecool.queststore.view.View;

import java.util.List;

public class LoginController {

    private final View view;
    private final UserDao userDao;
    private final InputProvider inputProvider;
    private final SessionController sessionController;


    public LoginController(SessionController sessionController){
        this.view = sessionController.getView();
        this.userDao = sessionController.getUserDao();
        this.inputProvider = sessionController.getInputProvider();
        this.sessionController = sessionController;

    }

    public void init() {
        userDao.displayAllUsers(); //For presentation
        User user = logIn();
        setMenuController(user);
    }

    private User logIn() {
        User loggedUser;
        String email;
        do {
            email = inputProvider.takeUserInput("Email: ");
            String password = inputProvider.takeUserInput("Password: ");
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
        return new UserDao().getUsers(
                "SELECT * FROM users WHERE email = '" + email + "' AND password = '"
                        + password + "';");
    }


    private void setMenuController(User loggedUser) {
        MenuController menuController;
        if (loggedUser instanceof Admin) {
            menuController = new AdminMenuController(loggedUser, view, userDao, sessionController);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printAdminMenu);
        } else if(loggedUser instanceof Mentor){
            menuController = new MentorMenuController(loggedUser, view, userDao, sessionController);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printMentorMenu);
        } else if(loggedUser instanceof Student) {
            menuController = new StudentMenuController(loggedUser, view, userDao);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printStudentMenu);
        }
    }
}
