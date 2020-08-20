package com.codecool.queststore;

import com.codecool.queststore.controller.LoginController;
import com.codecool.queststore.controller.SessionController;

public class Main {
    public static void main(String[] args) {

        SessionController sc = new SessionController();
        sc.initialize();
    }
}
