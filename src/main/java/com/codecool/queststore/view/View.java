package com.codecool.queststore.view;

import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class View {

    public void printArray(List<String[]> list) {
        list.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public void printResultSet(ResultSet resultSet) throws SQLException {
        System.out.println(FlipTableConverters.fromResultSet(resultSet));
    }

    public static void printLogin() {
        System.out.println("Enter your login");
        System.out.println("Enter your password");
    }
}
