package com.company;

import com.company.Actions.ActionAttack;
import com.company.Actions.ActionChangeStance;
import com.company.Actions.ActionWait;
import com.company.Body.Limb;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Fighter f0 = new Fighter("Fighter0");
        Fighter f1 = new Fighter("Fighter1");

        int gameCount = 0;

        while(true){
            System.out.println("GameCount : " + gameCount);
            gameCount++;
            if(f0.isReady()){
                System.out.println("Player 0 turn");
                playerTurn(f0,f1);
            }
            if(f1.isReady()) {
                System.out.println("Player 1 turn");
                playerTurn(f1, f0);
            }
            f0.update();
            f1.update();

        }

    }

    public static void playerTurn(Fighter player, Fighter opposition){ //TODO Remove opposition here
        String r = askAndScan("Fighter idle. What do now? (W)ait, (A)ttack, (P)osition");
        if(r.toUpperCase().contains("W")){
            player.setAction(new ActionWait(10,player));
        }
        if(r.toUpperCase().contains("A")){
            AttackData.AttackType type = (AttackData.AttackType)UserInterface.promptNumberedList("What attack type", Arrays.asList(AttackData.AttackType.values()));

            Limb lU = (Limb)UserInterface.promptNumberedList("What limb to use?",player.b.getAttackLimb());
            Limb lT = (Limb)UserInterface.promptNumberedList("What limb to target?",opposition.b.limblist);

            player.setAction(new ActionAttack(10,player,new AttackData(player,opposition,type,lU,lT)));
        }
        if(r.toUpperCase().contains("P")){
            Fighter.Position newPos = (Fighter.Position)UserInterface.promptList("Change stance to : (C)rouch,(S)tand,(K)neeling,(L)ying","CSKL",
            Fighter.Position.CROUCHING,Fighter.Position.STANDING,Fighter.Position.KNEELING,Fighter.Position.LYING);
            player.setAction(new ActionChangeStance(10,player,newPos));
        }
    }

    static Scanner s = new Scanner(System.in);
    public static String askAndScan(String q){
        System.out.println(q);
        return s.nextLine();
    }
}
