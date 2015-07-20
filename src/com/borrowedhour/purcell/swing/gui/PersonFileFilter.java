package com.borrowedhour.purcell.swing.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by borrowedhour on 7/19/15.
 */
public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {

        if (file.isDirectory()){
            return true;
        }

        String fileName = file.getName();

        String extension = Utils.getFileExtension(fileName);

        if (extension==null){
            return false;
        }

        if (extension.equals("per")){
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
