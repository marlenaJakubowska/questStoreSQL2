package com.codecool.queststore.inputProvider;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputProvider {

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
}
