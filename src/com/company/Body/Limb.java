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

    boolean canAttack = false;
    boolean canGrab;

    public Limb(String name){
        this.name = name;
        this.parent = null;
    }

    public void setCanAttack(boolean canAttack){
        this.canAttack = true;
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
        this.children.remove(parent);
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
