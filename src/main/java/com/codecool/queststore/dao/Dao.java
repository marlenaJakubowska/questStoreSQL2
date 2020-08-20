package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.User;
import com.codecool.queststore.view.View;

import java.sql.*;

public abstract class Dao<T> implements IUserDao{

    protected Connection connection;
    protected Statement statement;

    private final String url = "jdbc:postgresql://ec2-34-254-24-116.eu-west-1.compute.amazonaws.com" +
            ":5432/de0sdte5vtesls";
    private final String user = "ysbidcpezviicd";
    private final String password = "53e426929003e252f789e33bfdba58b73e4a4f0f24f49d1d5248d7061f3cb729";


    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB");
            statement = connection.createStatement();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Not connected");
        }
    }

    public void executeQuery(String  query){
        connect();
        try {
            statement.execute(query);
            statement.close();
            System.out.println("Test - query executed");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("Disconnected from DB");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Disconnecting failed");
        }
    }


}
