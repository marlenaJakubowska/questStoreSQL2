package com.codecool.queststore.dao;

import com.codecool.queststore.controller.AdminMenuController;
import com.codecool.queststore.controller.MenuController;
import com.codecool.queststore.model.users.*;
import com.codecool.queststore.view.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao<User> implements IUserDao{

    View view;
    private MenuController menuController;

    public UserDao() {
        view = new View();
    }


    public List<User> getUsers(String query) {
        List<User> users = new ArrayList<>();
        connect();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Role role = Role.valueOf(resultSet.getInt("role_id"));
                boolean isActive = resultSet.getBoolean("isActive");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                System.out.println(role);
                User user = new UserFactory(this).create(id, name, lastName, role, isActive, email, password);
                users.add(user);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void displayAllUsers() {
        System.out.println("test2");
        sendPrintQueryToDB("SELECT * FROM users");
    }

    public void sendPrintQueryToDB(String query) {
        System.out.println("test3");
        connect();
        try {
            System.out.println("test 5");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("test6");
            view.printResultSet(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User o) {

    }

    @Override
    public void edit(User o) {

    }

    @Override
    public void remove(User o) {

    }
}
