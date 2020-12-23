package com.xvr;

import com.xvr.document.Document;

public class DocumentProducerThread implements Runnable{

    private final Dispatcher dispatcher;

    public DocumentProducerThread (Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        System.out.println("Добавляем документ в очередь: ");
        try{
            for (int i = 0; i<30; i++){
                Document document = new Document();
                dispatcher.addDocumentToPrint(document);
                dispatcher.getQueue().forEach(document1 -> System.out.println(document1.hashCode()));
                Thread.sleep(2000);
                if (i==6) {
                    System.out.println("Поток добавления документов засыпает на 10 сек, для проерки ожидания");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Поток добавления документа прерван ");
        }
    }
}
