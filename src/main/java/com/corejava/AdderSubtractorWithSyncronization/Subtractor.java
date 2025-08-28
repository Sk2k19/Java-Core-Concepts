package com.corejava.AdderSubtractorWithSyncronization;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Count count;

    public Subtractor(Count count){
        this.count = count;

    }
    @Override
    public void run() {
        for(int i=1;i<=100;i++){

            count.addValue(i);

        }
    }
}
