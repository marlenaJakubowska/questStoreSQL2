package com.codecool.queststore.dao;

public interface IDao<T> {

    void add(T t);
    void edit(String[] inputData);
    void remove(T t);
}
