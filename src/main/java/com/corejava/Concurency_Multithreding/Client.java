package com.corejava.Concurency_Multithreding;

public class Client {
    public static void main(String[] args) {
        Printer p = new Printer();
        System.out.println("Hello world : thread name "+ Thread.currentThread().getName());
        Thread t1 = new Thread(p);
        t1.start();
    }
}
