package com.borrowedhour.purcell.swing.gui;

import com.borrowedhour.purcell.swing.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by borrowedhour on 7/18/15.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private Controller controller;

    public MainFrame() {
        super("Hello World");

        setVisible(true);
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400)); //this sets the minimum size that it can be minimized to,
                                                // before it distorts the window to an upgly size.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();

        setJMenuBar(createMenuBar());

        tablePanel.setData(controller.getPeople());

        toolbar.setStringListener(new StringListener() {
            public void stringEmitted(String s) {
                textPanel.appendText(s);
            }
        });

        formPanel.setFormListener(new FormListener(){
            public void formEventOccured(FormEvent ev) {
//                String name = ev.getName();
//                String occupation = ev.getOccupation();
//                int ageCat = ev.getAgeCategory();
//                String empCat = ev.getEmpCategory();
//                String taxId = ev.getTaxId();
//                boolean usCitizen = ev.isUsCitizen();
//                String gender = ev.getGender();
//
//                textPanel.appendText(name + ": "+occupation+" : "+ageCat+" : "+empCat+" : "+
//                        taxId+" : Is citizen:"+
//                        usCitizen+" : "+gender+"\n");

                controller.addPerson(ev);
                tablePanel.refresh();
            }
        });

        add(tablePanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
    }

    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        //File menu

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data..");
        JMenuItem importDataItem = new JMenuItem("Import Data..");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        //Window menu

        JMenu windowMenu= new JMenu("Window");

        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(item.isSelected());
            }
        });

        //Adding all to menu bar

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        //Adding Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F); //not sure why mnemonics are not working
        exitItem.setMnemonic(KeyEvent.VK_X); //same

        //Adding Accelerators
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //this is working

        //Adding listeners
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Adding Message Box
                int option = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Saving to file: " + fileChooser.getSelectedFile());
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save to file", "Saving Error",
                                JOptionPane.ERROR_MESSAGE);
                        e1.printStackTrace();
                    }
                }
            }
        });

        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Importing the data from: " + fileChooser.getSelectedFile());

                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh();
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not load file", "Loading error",
                                JOptionPane.ERROR_MESSAGE);
                        e1.printStackTrace();
                    }
                }
            }
        });

        return menuBar;
    }
}
