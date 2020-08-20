package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Dao<T> implements IUserDao{



    PostgresJDBC connection;
    Statement statement;
    View view;
//
//    public Dao() {
//        connection = new PostgresJDBC();
//        view = new View();
//
//    }




    public void executeQuery(String  query){
        connection.connect();
        try {
            statement.execute(query);
            statement.close();
            connection.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
