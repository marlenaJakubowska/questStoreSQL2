package com.codecool.queststore.dao;

import com.codecool.queststore.view.View;
import java.sql.*;

public abstract class Dao<T> extends ConnectDao implements IDao<T>{

     final View view = new View();

    public ResultSet executeSelectQuery(String  query){
        connect();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void executeInsertQuery(String  query){
        connect();
        try {
            statement.execute(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPrintQueryForDB(String table, String columns, String condition) {
        String where = condition.isEmpty() ? "" : "WHERE " + condition;
        String query = String.format("SELECT %s FROM %s %s;", columns, table, where);
        requestDataFromDB(query);
    }

    @Override
    public void edit(String[] inputData) {
        String table = inputData[0];
        String column = inputData[1];
        String newValue = inputData[2];
        String condition = inputData[3];

        if (column.toLowerCase().equals("id")) {
            System.out.println("Unable to change id");
            return;
        }

        String query = String.format("UPDATE %s SET %s = %s WHERE %s;", table, column, newValue, condition);
        executeInsertQuery(query);
    }

    public void requestDataFromDB(String query) {
        connect();
        try {
            ResultSet results = statement.executeQuery(query);
            view.printResultSet(results);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
