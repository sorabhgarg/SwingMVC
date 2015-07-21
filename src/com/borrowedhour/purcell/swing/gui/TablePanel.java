package com.borrowedhour.purcell.swing.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by borrowedhour on 7/20/15.
 */
public class TablePanel extends JPanel{

    private JTable table;
    private PersonTableModel tableModel;

    public TablePanel(){

        tableModel = new PersonTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(table, BorderLayout.CENTER);

    }
}
