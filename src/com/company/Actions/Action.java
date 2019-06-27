package com.company.Actions;

import com.company.Fighter;

public abstract class Action {

    protected Fighter parent;

    public Action(int total, Fighter f){
        totalTime = total;
        parent = f;
        onStart();
    }

    public long getTotalTime() {
        return totalTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public boolean isFinished() {
        return finished;
    }

    private long totalTime;
    private long elapsedTime = 0;

    /**
        Allows this action to be disposed of!
     */
    private boolean finished;

    public void update(){
        elapsedTime++;

        if(elapsedTime >= totalTime){
            onFinish();
            finished = true;
        }
    }

    public abstract void onStart();

    public abstract void onFinish();

    public abstract void onInterrupt(); //TODO Maybe add an InterruptEvent here! so that depending on the event something can happen :)



}
