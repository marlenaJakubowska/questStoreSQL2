package com.codecool.queststore;

import com.codecool.queststore.dao.PostgresDao;
import com.codecool.queststore.model.ModuleName;
import com.codecool.queststore.model.Quest;

public class Main {
    public static void main(String[] args) {

//        PostgresDao test = new PostgresDao();
//        test.setConnection();
//        test.closeConnection();

        String modelName = "Advanced";


        Quest quest1 = new Quest(1, "quest 1", 3500, ModuleName.JAVAOOP, "very easy quest");
        System.out.println(quest1.toString());
    }
}
