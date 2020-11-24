package com.xvr;

import com.xvr.util.CheckExtension;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dispatcher dispatcher = new Dispatcher();
        System.out.println("1. add file to print");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                JFileChooser chooser = new JFileChooser(System.getProperty("java.class.path"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        Scanner inputFile= new Scanner(new File(chooser.getSelectedFile().getAbsolutePath()));
                        File file = new File(chooser.getSelectedFile().getAbsolutePath());

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default: break;
        }

    }
}
