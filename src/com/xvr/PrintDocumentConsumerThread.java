package com.xvr;

import com.xvr.document.Document;

import java.util.Queue;

public class PrintDocumentConsumerThread implements Runnable {

    private final Queue queue;

    public PrintDocumentConsumerThread(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Document doc;
        System.out.println("Ждём документ... Поток - " + Thread.currentThread().getName());
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    System.out.println("WAITING: 0 document's in queue");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("printDoc " + queue.size());

                while (queue.size() != 0) {
                    if ((doc = (Document) queue.poll()) != null) {
                        System.out.println("ВЫПОЛНЯЮ ПЕЧАТЬ ДОКУМЕНТА: " + doc.hashCode());
                        try {
                            Thread.sleep(1500);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
                queue.notify();
            }
        }

    }
}

