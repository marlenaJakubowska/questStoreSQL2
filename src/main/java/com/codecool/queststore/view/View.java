package com.codecool.queststore.view;

import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public String takeUserInput(String message) {
        String userInput;
        Scanner scan = new Scanner(System.in);
        boolean invalidInput;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9@.]");

        do{
            System.out.println(message);
            userInput = scan.nextLine();
            invalidInput = pattern.matcher(userInput).find();

            if(invalidInput){
                System.out.println("That's not a valid input");
            }
        }while (invalidInput);
        return userInput;
    }

    public void printAdminMenu(){
        String[] headers = {"Options you can access:"};
        String[][] data = {
                {"[1] Add new mentor"},
                {"[2] Create class"},
                {"[3] Edit mentor"},
                {"[4] Show a mentor profile"},
                {"[5] Show list of all users"},
        };
        System.out.println(FlipTable.of(headers,data));
    }

    public void printMentorMenu() {
        String[] headers = {"Options you can access:"};
        String[][] data = {
                {"[1] Show students list"},
                {"[2] Add student to class"},
                {"[3] Edit student data"},
                {"[4] Add a quest"},
                {"[5] Check a quest"},
                {"[6] Edit a quest"},
                {"[7] Add a reward"},
                {"[8] Edit a reward"},
                {"[9] See the summary of students' wallets"},

        };
        System.out.println(FlipTable.of(headers,data));
    }

    public void printStudentMenu(){
        String[] headers = {"Options you can access:"};
        String[][] data = {
                {"[1] Show my wallet"},
                {"[2] Buy artifacts"},
                {"[3] Buy artifacts with friends"},
                {"[4] Show my level of experience"}


        };
        System.out.println(FlipTable.of(headers,data));
    }


}
