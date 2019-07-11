package com.company;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    static final Scanner s = new Scanner(System.in);

    //Don't like this one. Go for numbered list instead? more dwarfy.
    public static <T> Object  promptList(String prompt, String choices, T... vals){
        if(choices.length() != vals.length){
            System.err.println("promptUser() for \""+prompt+"\" has an unequal amount of choices in comparison to values. This is a failure. Exiting");
            System.exit(0);
        }
        System.out.println(prompt);
        int ind = getListChoice(prompt,choices);
        return vals[ind];
    }

    //TODO DOES NOT SUPPORT VALUES BIGGER THAN 9 (i.e no double digit answers)
    public static <T> Object  promptNumberedList(String prompt, List<T> vals){
        System.out.println(prompt);
        StringBuilder choices = new StringBuilder();
        for (int i = 0; i < vals.size();i++){
            System.out.println(i + " - " + vals.get(i).toString());
            choices.append(i);
        }
        int ind = getListChoice(prompt,choices.toString());
        return vals.get(ind);
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
