package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.Role;
import com.codecool.queststore.model.users.User;
import com.codecool.queststore.model.users.UserFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao<User> implements IUserDao{

    PostgresJDBC postgresJDBC;
    Statement statement;

    public UserDao() {
        postgresJDBC = new PostgresJDBC();


    }



    public List<User> getUsers(String query) {
        List<User> users = new ArrayList<>();
        connection.connect();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("surname");
                Role role = Role.valueOf(resultSet.getInt("roleId"));
                boolean isActive = resultSet.getBoolean("isActive");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                System.out.println(role);
                User user = new UserFactory().create(id, name, lastName, role, isActive, email, password);
                users.add(user);
            }
            resultSet.close();
            statement.close();
            connection.disconnect();
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
        connection.connect();
        try {
            ResultSet results = statement.executeQuery(query);
            view.printResultSet(results);
            connection.disconnect();
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
