package com.borrowedhour.purcell.swing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by borrowedhour on 7/18/15.
 */
public class Toolbar extends JPanel implements ActionListener{

    private JButton helloBtn;
    private JButton goodbyeBtn;
    private StringListener stringListener;

    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());

        setLayout(new FlowLayout(FlowLayout.LEFT));

        helloBtn = new JButton("Hello");
        goodbyeBtn = new JButton("Goodbye");

        helloBtn.addActionListener(this);
        goodbyeBtn.addActionListener(this);

        add(helloBtn);
        add(goodbyeBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked==helloBtn){
            if (stringListener!=null) {
                stringListener.stringEmitted("Hello\n");
            }
        }
        else if (clicked==goodbyeBtn){
            if (stringListener!=null) {
                stringListener.stringEmitted("Goodbye\n");
            }
        }
    }

    public void setStringListener(StringListener stringListener){
        this.stringListener=stringListener;
    }
}
