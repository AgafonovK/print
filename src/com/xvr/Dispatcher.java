package com.xvr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Dispatcher implements Runnable {

    private BlockingQueue <Integer> printQueue = new LinkedBlockingQueue<>();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;

    public void start(){
        worker = new Thread(this);
        worker.start();
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            Integer integer = null;
            try {
                integer = printQueue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (integer!=null) {
                new Thread(new Print(integer)).start();
            }
        }
    }


    List<Integer> stopDispatcher(){
        List<Integer> list = new ArrayList<Integer>(printQueue);
        printQueue.clear();
        return list;
    }

    public void addDocumentToPrint(Integer document){
        System.out.println("add document " + document);
        printQueue.add(document);
    }

    void cancelPrint(){

    }



}
