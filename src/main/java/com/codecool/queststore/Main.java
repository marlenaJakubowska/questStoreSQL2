package com.codecool.queststore;

import com.codecool.queststore.dao.PostgresDao;
import com.codecool.queststore.model.Category;
import com.codecool.queststore.model.ModuleName;
import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.users.Role;

public class Main {
    public static void main(String[] args) {

//        PostgresDao test = new PostgresDao();
//        test.setConnection();
//        test.closeConnection();


    int name = 1;
    Quest quest = new Quest(1, "quest 1", 500, ModuleName.valueOf(name), "dupa");
        System.out.println(quest);
    }
}
