package com.company;

public class AttackData {

    Fighter attacker;
    Fighter target;
    AttackType type;

    //TODO Add attack opts like heavy/light. Also add support for limb and weapon differentiation.z
    public AttackData(Fighter f0, Fighter f1, AttackType t){
        attacker = f0;
        target = f1;
        type = t;
    }

    public void onFailure(){ //If the attack failed to occur - e.x interrupted
        System.out.println("Fighter's attack failed... :(");
    }

    public void onSuccess(){ //If the attack successfully triggered. This passes it to attack manager who may decide he misses or something.
        System.out.println("Fighter attacked the thing!");
        AttackManager.processAttack(this);
    }

    enum AttackType{
        PUNCH,KICK
    }

}
