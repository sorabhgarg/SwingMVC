package com.borrowedhour.purcell.swing.gui;

import com.borrowedhour.purcell.swing.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by borrowedhour on 7/20/15.
 */
public class PersonTableModel extends AbstractTableModel{

    private List<Person> db;
    private String[] columnNames = {"ID", "Name", "Occupation", "Age Category", "Employment Category", "US citizen",
            "Tax ID", "Gender"};

    public void setData(List<Person> db) {
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getEmpCategory();
            case 5:
                return person.isUsCitizen();
            case 6:
                return person.getTaxId();
            case 7:
                return person.getGender();
        }
        return null;
    }
}
