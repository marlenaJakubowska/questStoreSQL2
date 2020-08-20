package com.codecool.queststore.controller;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.model.users.UserFactory;
import com.codecool.queststore.view.View;

import java.util.HashMap;
import java.util.Map;

public abstract class MenuController {

    protected final View view;
    private final UserDao userDao;
    protected User user;
    private final UserFactory userFactory;
    private Role role;
    protected Map<String, Runnable> mainMenuMap;

    public MenuController(User user, View view) {
        this.user = user;
        this.view = view;
        mainMenuMap = new HashMap<>();
        this.userDao = new UserDao();
        this.userFactory = new UserFactory(userDao);
    }

    public void handleMenu(Map<String, Runnable> menuMap, Runnable uiMenu) {
        boolean isRunning = true;
        do {
            uiMenu.run();
            String input = view.takeUserInput("Choose option ");
            if (input.equals("0")) {
                isRunning = false;
                continue;
            }
            try {
                menuMap.get(input).run();
            } catch (NullPointerException e) {
                System.out.println("No such option");
            }
        } while (isRunning);
    }

    public Map<String, Runnable> getMainMenuMap() {
        return mainMenuMap;
    }
}
