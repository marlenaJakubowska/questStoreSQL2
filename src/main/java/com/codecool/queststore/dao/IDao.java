package com.codecool.queststore.dao;

import java.util.List;

public interface IDao<T> {

    void add(T t);
    void edit(String[] inputData);
    void remove(T t);
    List<T> getAll();

}
