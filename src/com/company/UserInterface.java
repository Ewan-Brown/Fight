package com.company;

import java.util.Scanner;

public class UserInterface {

    static final Scanner s = new Scanner(System.in);

    public static <T> Object  promptList(String prompt, String choices, T... vals){
        if(choices.length() != vals.length){
            System.err.println("promptUser() for \""+prompt+"\" has an unequal amount of choices in comparison to values. This is a failure. Exiting");
            System.exit(0);
        }
        System.out.println(prompt);
        int ind = getListChoice(prompt,choices);
        return vals[ind];
    }

    public static int getListChoice(String prompt, String choices){
        boolean valid = false;
        int choiceIndx = 0;
        while(!valid){
            String input = s.nextLine();
            choiceIndx = choices.indexOf(input);
            if(input.length() == 1 && choiceIndx != -1){
                valid = true;
            }
            else{
                System.out.println("Invalid Input : ["+input+"]");
            }
        }
        return choiceIndx;
    }

}
