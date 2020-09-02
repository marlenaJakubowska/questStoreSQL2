package com.codecool.queststore.controller;

import com.codecool.queststore.dao.*;
import com.codecool.queststore.inputProvider.InputProvider;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

import java.util.List;

public class SessionController {

    private IUserDao userDao;
    private final InputProvider inputProvider= new InputProvider();
    private final QuestDao questDao = new QuestDao();
    private final RewardDao rewardDao = new RewardDao();
    private final View view = new View();

    public SessionController(ConnectDao connectDao) {
        this.userDao = new UserDao(connectDao);
        this.userDao = new UserCSVDao("connectDao");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public InputProvider getInputProvider() {
        return inputProvider;
    }

    public QuestDao getQuestDao() {
        return questDao;
    }

    public RewardDao getRewardDao() {
        return rewardDao;
    }

    public View getView() {
        return view;
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
