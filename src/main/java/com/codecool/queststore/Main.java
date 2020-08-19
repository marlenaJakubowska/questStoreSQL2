package com.codecool.queststore;

import com.codecool.queststore.dao.PostgresDao;

public class Main {
    public static void main(String[] args) {

        PostgresDao test = new PostgresDao();
        test.setConnection();
        test.closeConnection();
    }
}
