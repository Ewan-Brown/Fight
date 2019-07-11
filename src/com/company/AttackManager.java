package com.company;

public class AttackManager {

    public static void processAttack(AttackData data){
        if(data.type == AttackData.AttackType.DISCONNECT){
            System.out.println("Attacking target limb of " + data.targetLimb.toString());
            data.target.b.disconnectLimb(data.targetLimb);
            data.target.b.updateLimbList();
        }
        if(data.type == AttackData.AttackType.DESTROY){
            System.out.println("Attacking target limb of " + data.targetLimb.toString());
            data.target.b.destroyLimb(data.targetLimb);
            data.target.b.updateLimbList();
        }
    }

}
