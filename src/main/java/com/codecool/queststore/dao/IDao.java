package com.codecool.queststore.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    void add(T t);
    void edit(T t);
    void remove(T t);
}
