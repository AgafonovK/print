package com.xvr;

import com.xvr.document.Document;
import com.xvr.document.PaperSizeDocument;
import com.xvr.document.TypeDocument;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Dispatcher implements Runnable {


    private Thread printConsumerThread;
    private Thread documentProducerThread;
    private Queue<Document> queue = new LinkedBlockingQueue<>();
    private int counterSizeQueue = 0;

    @Override
    public void run() {

        try {
            //init();

            printConsumerThread = new Thread(new PrintDocumentConsumerThread(this));
            printConsumerThread.setName("PrintDocumentThread");
            System.out.println("Стартуем поток печати " + printConsumerThread.getName());
            printConsumerThread.start();

            documentProducerThread = new Thread(new DocumentProducerThread(this));
            documentProducerThread.setName("documentProducerThread");
            System.out.println("Стартуем поток добавления документа " + documentProducerThread.getName());
            documentProducerThread.start();

            System.out.println("ожидаем заключения работы потока печати");
            printConsumerThread.join();
            System.out.println("Поток печати остановил свою работу ");

            System.out.println("ожидаем заключения работы потока добавления документов");
            documentProducerThread.join();
            System.out.println("Поток добавления документов остановил свою работу");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Init may be used where we want in start process have the queue with 2 elements
    public void init() throws InterruptedException {
        Document document = new Document(PaperSizeDocument.A3);
        Document document1 = new Document(Duration.ZERO, PaperSizeDocument.A4, TypeDocument.doc);
        queue.add(document);
        queue.add(document1);
        System.out.println("добавляем два документа в очередь.. ");
        queue.forEach((a) -> System.out.println("документ: " + a.hashCode()));
        System.out.println("размер очереди при инициализаций " + queue.size());

    }

    //TODO IT'S Lock with Thread Add document
    public synchronized Queue<Document> getQueue() throws InterruptedException {
        while (queue.size() == 0) {
            System.out.println("сколько напечатано " + counterSizeQueue);
            wait();
        }
        return queue;

    }

    public synchronized void setQueue(Queue setQueue) {
        this.queue = setQueue;
    }

    public synchronized void addDocumentToPrint(Document document) throws InterruptedException {
        queue.add(document);
        System.out.println("документ " + document.hashCode() + " добавлен в очередь ");
        counterSizeQueue += 1;
        System.out.println("общий счетчик документов counterSizeQueue = " + counterSizeQueue);
        if (counterSizeQueue == 25) {
            stopDispatcher();
        }
        notify();
    }

    // interrupt thread Print and clear queue and list unprint document
    public void stopDispatcher() throws InterruptedException {
        System.out.println("Запускаем остановку диспетчера с выводом списка не напечатанных документов ");

        if (printConsumerThread.isAlive()) {
            System.out.println("Останавливаем поток печати");
            printConsumerThread.interrupt();
        }

        if (documentProducerThread.isAlive()){
            System.out.println("Останавливаем поток добавления документов");
            documentProducerThread.interrupt();
        }

        Thread.sleep(1000);
        List<Document> unprintedList = new LinkedList<Document>(getQueue());
        System.out.println("Не напечатанные документы: ");
        unprintedList.forEach(document -> System.out.println(document.hashCode()));
        queue.clear();
        System.out.println("тормозит диспетчер");

        Thread.sleep(3000);
    }

    //TODO this method need todo
    public void cancelPrint() {
        /*if (printConsumerThread.isAlive()) {
            printConsumerThread.interrupt();
            System.out.println("Print end");
        } else {
            System.out.println("Print not started yet");
        }*/

    }



}
