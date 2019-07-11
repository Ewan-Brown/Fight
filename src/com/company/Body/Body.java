package com.company.Body;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * This class and Limb should do no calculations except ion creation. Attackmanager should doeal with whether something happens or not and to what degree.
 */
public class Body {
    public List<Limb> limblist = new ArrayList<>();
    Limb origin;

    private Body(){

    }

    public List<Limb> getAttackLimb(){
        List<Limb> attackLimbs = limblist.stream().filter(limb -> limb.canAttack()).collect(Collectors.toUnmodifiableList());
        return attackLimbs;
    }

    public void setOrigin(Limb o){
        origin = o;
    }

    public void updateLimbList(){
        limblist = getChildrenRecurs(origin);
    }

    public static List<Limb> getChildrenRecurs(Limb base){
        List<Limb> list = new ArrayList<>();
        list.add(base);
        for(Limb child  : base.children){
            list.addAll(getChildrenRecurs(child));
        }
        return list;
    }

    public void disconnectLimb(Limb l){
        l.disconnect();
    }

    public void destroyLimb(Limb l){
        l.destroy();
    }

    public static Body getBasicBody(){
        Body b = new Body();
        Limb torso = new Limb("Torso");
        Limb head = new Limb("Head");
        Limb armL = createArm("Left");
        Limb armR = createArm("Right");

        b.setOrigin(head);

        head.setParent(null); //Origin limb!
        head.addChild(torso);
        torso.addChild(armL);
        torso.addChild(armR);
        b.updateLimbList();
        return b;
    }

    public static Limb createArm(String pre){
        Limb uArm = new Limb(pre + "UpperArm");
        Limb lArm = new Limb(pre + "LowerArm");
        Limb hand = new Limb(pre + "Hand");

        uArm.addChild(lArm);
        lArm.addChild(hand);

        return uArm;
    }
}
