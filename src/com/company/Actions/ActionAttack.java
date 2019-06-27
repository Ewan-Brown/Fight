package com.company.Actions;

import com.company.AttackData;
import com.company.Fighter;

public class ActionAttack extends Action{

    AttackData data;

    public ActionAttack(int t, Fighter f, AttackData d){
        super(t, f);
        data = d;
    }

    public void onStart() { }

    public void update(){
        super.update();
    }

    public void onFinish() {
        data.onSuccess();
    }

    //TODO When does this fail??? How is that triggered and should there be multiple fail modes???
    public void onInterrupt() {
        data.onFailure();
    }
}
