package com.borrowedhour.purcell.swing.gui;

import com.borrowedhour.purcell.swing.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        add(new JScrollPane(table), BorderLayout.CENTER);

    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
