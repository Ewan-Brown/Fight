package com.company;

import com.company.Body.Limb;

public class AttackData {

    Fighter attacker;
    Fighter target;
    AttackType type;
    Limb targetLimb;
    Limb usedLimb;

    public AttackData(Fighter f0, Fighter f1, AttackType type, Limb usedLimb, Limb targetLimb){
        attacker = f0;
        target = f1;
        this.type = type;
        this.targetLimb = targetLimb;
        this.usedLimb = usedLimb;
    }

    public void onFailure(){ //If the attack failed to occur - e.x interrupted
        System.out.println("Fighter's attack failed... :(");
    }

    public void onSuccess(){ //If the attack successfully triggered. This passes it to attack manager who may decide he misses or something.
        System.out.println("Fighter attacked the thing!");
        AttackManager.processAttack(this);
    }

    enum AttackType{
        DESTROY, DISCONNECT
    }

}
