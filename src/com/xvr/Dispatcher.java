package com.xvr;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Dispatcher {

    private BlockingQueue <Document> printQueue = new LinkedBlockingQueue<Document>();


    List<Document> stopDispatcher(){
        return null;
    };

    public void addDocumentToPrint(Document document){
        printQueue.add(document);
    };

    void cancelPrint(){

    };

}
