package com.corejava.AdderSubtractorWithSyncronization;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    Count count;

    public Adder(Count count){
        this.count = count ;

    }
    @Override
    public void run() {
        for(int i=1;i<=100;i++){

            count.addValue(i); // this is critical section
        }
    }
}
