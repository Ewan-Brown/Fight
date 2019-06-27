package com.company;

import com.company.Actions.Action;

import java.util.Scanner;

public class Fighter {


    public enum Position{
        STANDING,
        CROUCHING,
        KNEELING,
        LYING;
    }

    Position posn;

    public Position getPosition(){
        return posn;
    }

    public void setPosition(Position p){
        posn = p;
    }

    private Action action;

    public void update(){
        try{
            action.update();
            if(action.isFinished()){
                action = null;
            }
        }catch(NullPointerException e){
            System.err.println("Hey this fighter has a null Action and it tried to update! This is very illegal. Any key to continue");
            String s = new Scanner(System.in).nextLine();
        }

    }

    public boolean isReady(){ //Fighter is ready for next player input
        return (action == null);
    }

    public void setAction(Action a){
        action = a;
    }

}
