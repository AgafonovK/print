package com.xvr;


public class Main {

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();
        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();

        while (dispatcherThread.isAlive()) {
        }
        System.out.println("Bye bye");
        System.exit(0);
    }
}
