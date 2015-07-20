package com.borrowedhour.purcell.swing.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by borrowedhour on 7/18/15.
 */
public class TextPanel extends JPanel{

    private JTextArea textArea;

    public TextPanel() {

        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String s){
        textArea.append(s);
    }
}
