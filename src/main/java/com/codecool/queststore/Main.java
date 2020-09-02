package com.codecool.queststore;

import com.codecool.queststore.controller.LoginController;
import com.codecool.queststore.controller.SessionController;
import com.codecool.queststore.dao.ConnectDao;

public class Main {
    public static void main(String[] args) {

        ConnectDao connectDao = new ConnectDao();
        SessionController sc = new SessionController(connectDao);
        LoginController loginController = new LoginController(sc);
        loginController.init();
    }
}
