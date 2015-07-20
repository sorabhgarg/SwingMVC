package com.borrowedhour.purcell.swing.com.borrowedhour.purcell.swing.controller;

import com.borrowedhour.purcell.swing.gui.FormEvent;
import com.borrowedhour.purcell.swing.model.Database;
import com.borrowedhour.purcell.swing.model.Person;

/**
 * Created by borrowedhour on 7/20/15.
 */
public class Controller {

    Database db = new Database();

    public void addPerson(FormEvent event){

        String name = event.getName();
        String occupation = event.getOccupation();
        int ageCategory = event.getAgeCategory();
        String employmentCategory = event.getEmpCategory();
        boolean isUsCitizen = event.isUsCitizen();
        String taxId = event.getTaxId();
        String gender = event.getGender();

      //  Person person = new Person(name, occupation, ageCategory);

        //db.addPerson(person);
    }
}
