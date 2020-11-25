package com.xvr;

public class Print implements Runnable {

    Integer queue;

    Print(Integer queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        //to print
        Integer integer = queue;
        System.out.println(integer);
    }
}
