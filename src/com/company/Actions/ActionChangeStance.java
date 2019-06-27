package com.company.Actions;

import com.company.Fighter;
import com.company.Main;

public class ActionChangeStance extends Action{


    public ActionChangeStance(int total, Fighter f, Fighter.Position nPos) {
        super(total, f);
        newPos = nPos;
    }

    Fighter.Position newPos;

    @Override
    public void onStart() { }

    @Override
    public void onFinish() {
        parent.setPosition(newPos);
    }

    @Override
    public void onInterrupt() {

    }
}
