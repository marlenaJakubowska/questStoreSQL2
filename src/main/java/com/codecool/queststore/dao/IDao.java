package com.codecool.queststore.dao;

import java.sql.SQLException;

public interface IDao<T> {

    void add(T t) throws SQLException;
    void edit(T t) throws SQLException;
    void remove(T t) throws SQLException;
}
