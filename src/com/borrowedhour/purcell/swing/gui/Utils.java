package com.borrowedhour.purcell.swing.gui;

/**
 * Created by borrowedhour on 7/19/15.
 */
public class Utils {

    public static String getFileExtension(String fileName) {

        int pointIndex = fileName.lastIndexOf(".");

        if (pointIndex==-1){
            return null;
        }

        if (pointIndex==fileName.length()-1){
            return null;
        }

        return fileName.substring(pointIndex+1, fileName.length());

    }
}
