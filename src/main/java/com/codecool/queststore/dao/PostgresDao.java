package com.codecool.queststore.dao;

import java.sql.SQLException;

public class PostgresDao implements IDao{

    ConnectionToPostgres connection;

    public PostgresDao() {
        connection = new ConnectionToPostgres();
    }

    public void setConnection() {
        connection.connect();
    }

    public void closeConnection() {
        connection.disconnect();
    }


    @Override
    public void add(Object o) throws SQLException {

    }

    @Override
    public void edit(Object o) throws SQLException {

    }

    @Override
    public void remove(Object o) throws SQLException {

    }
}
