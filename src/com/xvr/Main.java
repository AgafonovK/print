package com.xvr;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private Thread thread;

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();
        Thread thread = new Thread(dispatcher);
        thread.start();
        System.out.println("1. add file to print");
        while (true) {
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1:
                    dispatcher.addDocumentToPrint(1);
                    break;
                case 2:
                    dispatcher.addDocumentToPrint(2);
                    break;
                case 3:
                    dispatcher.addDocumentToPrint(3);
                    break;
                case 4:
                    System.out.println(dispatcher.stopDispatcher());
                    break;
                default:
                    return;
            }
        }
    }
}
