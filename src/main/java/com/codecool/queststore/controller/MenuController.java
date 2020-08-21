package com.codecool.queststore.controller;
import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;
import java.util.HashMap;
import java.util.Map;

public abstract class MenuController {

    protected final View view;
    protected final UserDao userDao;
    private final InputProvider inputProvider;
    protected User user;
    protected Map<String, Runnable> mainMenuMap;

    public MenuController(User user, View view, UserDao userDao) {
        this.user = user;
        this.view = view;
        this.userDao = userDao;
        this.inputProvider = new InputProvider();
        mainMenuMap = new HashMap<>();
    }

    public void handleMenu(Map<String, Runnable> menuMap, Runnable uiMenu) {
        boolean isRunning = true;
        do {
            uiMenu.run();
            String input = inputProvider.takeUserInput("Choose option ");
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

    public void getUserEditInfo(){
        String id = inputProvider.takeUserInput("Enter user id to edit: ");
        String column = inputProvider.takeUserInput("Enter user column: ");
        String newValue = inputProvider.takeUserInput("Enter new value: ");
        userDao.formatUserInput(id, column, newValue);
    }

    public Map<String, Runnable> getMainMenuMap() {
        return mainMenuMap;
    }
}
