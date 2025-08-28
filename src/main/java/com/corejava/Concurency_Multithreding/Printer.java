package com.corejava.Concurency_Multithreding;

public class Printer implements Runnable{
    @Override
    public void run(){
        System.out.print("Hellp world : name of thread is = "+Thread.currentThread().getName());

    }
}
