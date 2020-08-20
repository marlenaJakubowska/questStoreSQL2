package com.codecool.queststore.dao;

import com.codecool.queststore.model.users.User;

import java.util.List;

public interface IUserDao extends IDao<User>{
    List<User> getAll();
}
