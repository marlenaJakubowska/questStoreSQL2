package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.User;

import java.util.List;

public class UserCSVDao implements IUserDao {
    public UserCSVDao(String filePath) {
    }

    @Override
    public void add(User user) {
        file.addRow(user);
    }

    @Override
    public void edit(String[] inputData) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
