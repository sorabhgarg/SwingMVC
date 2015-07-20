package com.borrowedhour.purcell.swing.gui;

import java.awt.event.ActionEvent;
import java.util.EventObject;

/**
 * Created by borrowedhour on 7/19/15.
 */
public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCategory;
    private String empCategory;
    private String taxId;
    private boolean usCitizen;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, int ageCategory, String empCategory, String taxId,
                     boolean usCitizen, String gender) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getEmpCategory() {
        return empCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public String getGender() {
        return gender;
    }
}
