package com.company.Body;

import java.util.ArrayList;

/**
 *
 * Represents a limb that contains organs.
 * Children are outwards from body centre, Parent is towards body centre.
 * If disconnected the parent removes this limb from the 'main' body and this limb and its' recursive children become a separate body
 *
 * Composed of:
 *
 * Outer layer (skin)
 *
 * Middle layers (Fat, Muscle)
 *
 */
public class Limb {
    String name;
    ArrayList<Limb> children = new ArrayList<>();
    Limb parent;


    //All these are from [0-1]d
    double skinIntact;    //percent of skin left intact
    double bruising;      //percent of bruising
    double nerveHealth;   //percent nerve health
    double boneStructure; //percent bone broken - .25 fractured, .50 broke, .75 pulverized?

    Limb LimbUseTop; //pointer to the end of this limb 'link' Everything between the link and *this* is used for this limb's uses. Allows entire arm to have affect on hand use
    enum LimbUse{
        ATTACK,GRAB,BITE,BLOCK,
    }

    boolean canAttack = false;

    public Limb(String name){
        this.name = name;
        this.parent = null;
    }

    public void setCanAttack(boolean canAttack){
        this.canAttack = canAttack;
    }

    public boolean canAttack(){
        return canAttack;
    }

    public void setParent(Limb l){
        parent = l;
    }

    public void addChild(Limb l){
        children.add(l);
        l.setParent(this);
    }

    public void disconnect(){
        this.parent.children.remove(this);
    }

    public void destroy(){
        this.parent.children.remove(this);
        for(Limb l : children){
            l.parent = null;
        }
    }

    public String toString(){
        return "Limb : " + name;
    }
}
