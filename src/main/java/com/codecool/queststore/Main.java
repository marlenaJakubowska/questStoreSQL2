package com.codecool.queststore;


import com.codecool.queststore.controller.LoginController;
import com.codecool.queststore.dao.Dao;
import com.codecool.queststore.dao.UserDao;


public class Main {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        loginController.init();
    }
}
