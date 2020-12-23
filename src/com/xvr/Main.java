package com.xvr;


public class Main {

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();
        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();

        while (dispatcherThread.isAlive()) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Bye bye");
        System.exit(0);
    }
}
