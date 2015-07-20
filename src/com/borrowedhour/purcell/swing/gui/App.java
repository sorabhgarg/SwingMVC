package com.borrowedhour.purcell.swing.gui;

import javax.swing.*;

/**
 * Created by borrowedhour on 7/18/15.
 */
public class App {

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
