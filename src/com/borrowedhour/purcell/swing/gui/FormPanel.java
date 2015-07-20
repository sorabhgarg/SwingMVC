package com.borrowedhour.purcell.swing.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by borrowedhour on 7/18/15.
 */
public class FormPanel extends JPanel {

    private JLabel nameLabel, occupationLabel;
    private JTextField nameField, occupationField;
    private JButton okBtn;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JLabel taxLabel;
    private JTextField taxField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {
        Dimension dimension = getPreferredSize();
        dimension.width=270;
        setPreferredSize(dimension);
        setMinimumSize(dimension);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);

        //Setting up JList
        ageList = new JList();

        Dimension dimension1 = ageList.getPreferredSize();
        dimension1.setSize(114, 66);
        ageList.setPreferredSize(dimension1);

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory("Below 18", 0));
        ageModel.addElement(new AgeCategory("18 to 65", 1));
        ageModel.addElement(new AgeCategory("Above 65", 2));

        ageList.setModel(ageModel);
        ageList.setSelectedIndex(1);

        //Setting up ComboBox
        empCombo = new JComboBox();

        Dimension dimension2 = empCombo.getPreferredSize();
        dimension2.setSize(10, 10);
        empCombo.setSize(dimension2);

        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setEditable(true);

        //Setting up tax id
        citizenCheck = new JCheckBox();
        taxLabel = new JLabel("Tax ID:");
        taxField = new JTextField(10);

        taxLabel.setEnabled(false);
        taxField.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = citizenCheck.isSelected();
                taxField.setEnabled(isChecked);
                taxLabel.setEnabled(isChecked);
            }
        });

        //Setting gender radio buttons

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);

        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");

        //Setting up OK button
        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCategory = (String) empCombo.getSelectedItem();
                String taxId = taxField.getText();
                boolean isUsCitizen = citizenCheck.isSelected();
                String gender = genderGroup.getSelection().getActionCommand();

                System.out.println(ageCat.getId());

                FormEvent ev = new FormEvent(e, name, occupation, ageCat.getId(), empCategory, taxId, isUsCitizen, gender);

                if (formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }
        });

        layoutComponents();

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        /// row 1 ///

        gc.gridy=0;

        gc.weightx=1;
        gc.weighty=0.1;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(nameLabel,gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(nameField,gc);


        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.1;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(occupationLabel,gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(occupationField,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(new JLabel("Age: "),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(ageList,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(new JLabel("Employment: "),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(empCombo,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(new JLabel("US Citizen?: "),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(citizenCheck,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(taxLabel,gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(taxField,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.05;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets= new Insets(0,0,0,5);
        add(new JLabel("Gender: "),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(maleRadio,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(femaleRadio,gc);

        /// next row ///

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=2.0;

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(0,0,0,0);
        add(okBtn,gc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}

class AgeCategory{

    private String ageCategory;
    private int id;

    public AgeCategory(String ageCategory, int id) {
        this.ageCategory = ageCategory;
        this.id = id;
    }

    @Override
    public String toString() {
        return ageCategory;
    }

    public int getId() {
        return id;
    }
}
