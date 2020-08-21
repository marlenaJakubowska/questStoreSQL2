package com.codecool.queststore.service;

import com.codecool.queststore.dao.UserDao;
import com.codecool.queststore.inputProvider.InputProvider;

public class AdminService {

    private final static InputProvider inputProvider = new InputProvider();
    private final static UserDao userDao = new UserDao();

    public static void updateMentorName(int id) {
        String nameToUpdate = inputProvider.takeUserInput("Enter new name: ");
        userDao.updateUserFirstNameById(id, nameToUpdate);

    }


}
