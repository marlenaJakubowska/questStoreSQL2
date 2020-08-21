package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.*;
import com.codecool.queststore.view.View;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao<User> implements IUserDao{

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
        requestDataFromDB("SELECT * FROM users");
    }

    public void createPrintQueryUserTable(String column, String condition) {
        createPrintQueryForDB("users", column, condition);
    }

    public void formatUserInput(String id, String column, String newValue) {
        newValue = String.format("'%s'", newValue);

        prepareToEdit("users", id, column, newValue);
    }

    public void prepareToEdit(String table, String id, String column, String newValue) {
        String condition = String.format("id = %s", id);
        String[] inputData = {table, column, newValue, condition};
        edit(inputData);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {
        String query = String.format(
                "INSERT INTO users (first_name, last_name, role_id, isActive, email, password) values ('%s', '%s', %d, %b, '%s', '%s');",
                user.getFirstName(),
                user.getLastName(),
                user.getRole().getRoleId(),
                user.isActive(),
                user.getLogin(),
                user.getPassword()
        );
        executeInsertQuery(query);
    }

    @Override
    public void remove(User o) {

    }


}
