package com.codecool.queststore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDao {

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
}
