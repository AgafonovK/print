package com.xvr.util;

public class CheckExtension {

    private static String extension = "";

    public static String checkExtension(String fileName) {
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        return extension;
    }
}
