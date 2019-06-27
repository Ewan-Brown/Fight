package com.company;

import com.company.Actions.ActionAttack;
import com.company.Actions.ActionChangeStance;
import com.company.Actions.ActionWait;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Fighter f0 = new Fighter();
        Fighter f1 = new Fighter();

        int gameCount = 0;

        while(true){
            System.out.println(gameCount);
            gameCount++;
            if(f0.isReady()){
                playerTurn(f0,f1);
            }
            f0.update();

        }

    }

    public static void playerTurn(Fighter player, Fighter opposition){
        String r = askAndScan("Fighter idle. What do now? (W)ait, (A)ttack, (P)osition");
        if(r.toUpperCase().contains("W")){
            player.setAction(new ActionWait(10,player));
        }
        if(r.toUpperCase().contains("A")){
            AttackData.AttackType type = null;
            while(type == null){
                String s = Main.askAndScan("What attack type you want? (P)unch, (K)ick");
                switch(s.toUpperCase()){
                    case "P":
                        type = AttackData.AttackType.PUNCH;
                        break;
                    case "K":
                        type = AttackData.AttackType.KICK;
                }
            }
            player.setAction(new ActionAttack(10,player,new AttackData(player,opposition,type)));
        }
        if(r.toUpperCase().contains("P")){
            Fighter.Position newPos = null;
            boolean finished = false;
            while(!finished) {
                finished = true;
                String s = Main.askAndScan("What stance you wanting? (SCKL)");
                switch(s.toUpperCase()){ //TODO Maybe use a hashmap here??? Would be very readable!
                    case "S":
                        newPos = Fighter.Position.STANDING;
                        break;
                    case "C":
                        newPos = Fighter.Position.CROUCHING;
                        break;
                    case "K":
                        newPos = Fighter.Position.KNEELING;
                        break;
                    case "L":
                        newPos = Fighter.Position.LYING;
                        break;
                }
                if (newPos == null || newPos == player.getPosition()) {
                    finished = false;
                    System.out.println("Hey this is not an allowed target position!");
                }
            }
            player.setAction(new ActionChangeStance(10,player,newPos));
        }
    }

    static Scanner s = new Scanner(System.in);
    public static String askAndScan(String q){
        System.out.println(q);
        return s.nextLine();
    }
}
