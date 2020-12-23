package com.xvr;

import com.xvr.document.Document;

import java.util.Queue;

public class DocumentProducerThread implements Runnable {

    private final Queue queue;

    public DocumentProducerThread(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Добавляем документ в очередь: ");

            for (int i = 0; i < 30; i++) {
                try {
                Document document = new Document();
                synchronized (queue) {
                    queue.add(document);
                    System.out.println("документ " + document.hashCode() + " добавлен в очередь ");
                    //Thread.sleep(500);
                    queue.notify();
                    queue.wait();
                }
                if (i == 6) {
                    System.out.println("Поток добавления документов засыпает на 1 сек, для проерки ожидания");
                    Thread.sleep(1000);
                }


        } catch (InterruptedException e) {
            System.out.println("Поток добавления документа прерван ");
        }}
    }
}
