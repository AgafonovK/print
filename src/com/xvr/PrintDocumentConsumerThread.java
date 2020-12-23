package com.xvr;

import com.xvr.document.Document;

public class PrintDocumentConsumerThread implements Runnable {

    private final Dispatcher dispatcher;

    public PrintDocumentConsumerThread(Dispatcher d) {
        this.dispatcher = d;
    }

    @Override
    public void run() {
        Document doc;
        System.out.println("Ждём документ... Поток - " + Thread.currentThread().getName());
        try {
                while (dispatcher.getQueue().size() > 0) {
                    if ((doc = dispatcher.getQueue().poll()) != null) {
                        System.out.println("ВЫПОЛНЯЮ ПЕЧАТЬ ДОКУМЕНТА: " + doc.hashCode());
                        //Thread.sleep(1500);
                    }
                }

        } catch (InterruptedException e) {
            System.out.println("Поток печать документа прерван.");
        }
    }
}

