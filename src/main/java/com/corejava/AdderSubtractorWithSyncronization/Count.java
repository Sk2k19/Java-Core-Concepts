package com.corejava.AdderSubtractorWithSyncronization;

public class Count {
    private int value;

    public Count(int value){
        this.value = value;
    }
    public synchronized void addValue(int i){
        value+=i;
        return ;
    }
    public int getValue(){
        return value;
    }
}
