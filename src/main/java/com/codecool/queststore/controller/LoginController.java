package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.Admin;
import com.codecool.queststore.model.users.Mentor;
import com.codecool.queststore.model.users.Student;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

import java.util.List;

public class LoginController {

    private View view;
    private MenuController menuController;
    private UserDao userDao;

    public LoginController() {
        init();
    }

    public void init() {
        view = new View();
        userDao = new UserDao();
        userDao.displayAllUsers(); //For presentation
        User user = logIn();
        setMenuController(user);

    }

    private User logIn() {
        User loggedUser;
        String email;
        do {
            email = view.takeUserInput("Email: ");
            String password = view.takeUserInput("Password: ");
            loggedUser = loginTry(email, password);
        } while (loggedUser == null);
        System.out.println("Logged in");
        //setMenuController(loggedUser);
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
        if (loggedUser instanceof Admin) {
            menuController = new AdminMenuController(loggedUser, view);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printAdminMenu);
        } else if(loggedUser instanceof Mentor){
            menuController = new MentorMenuController(loggedUser, view);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printMentorMenu);
        } else if(loggedUser instanceof Student) {
            menuController = new StudentMenuController(loggedUser, view);
            menuController.handleMenu(menuController.getMainMenuMap(), view::printStudentMenu);
        }
    }
}
