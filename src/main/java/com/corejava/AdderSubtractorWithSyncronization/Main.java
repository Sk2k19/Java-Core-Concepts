package com.corejava.AdderSubtractorWithSyncronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] arg){
        Count count = new Count(0);

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        ExecutorService exeutor = Executors.newCachedThreadPool();
        exeutor.submit(adder);
        exeutor.submit(subtractor);
        exeutor.shutdown();
        System.out.print("Value of count object is "+count.getValue());
        // if we used the thread then we can use join() method to execute all thread before printing vakue ;
    }
}
