package com.borrowedhour.purcell.swing.controller;

import com.borrowedhour.purcell.swing.gui.FormEvent;
import com.borrowedhour.purcell.swing.model.*;

import java.util.List;

/**
 * Created by borrowedhour on 7/20/15.
 */
public class Controller {

    Database db = new Database();

    public List<Person> getPeople(){
        return db.getPeople();
    }

    public void addPerson(FormEvent event){

        String name = event.getName();
        String occupation = event.getOccupation();
        int ageCategory = event.getAgeCategory();
        String employmentCategory = event.getEmpCategory();
        boolean isUsCitizen = event.isUsCitizen();
        String taxId = event.getTaxId();
        String gender = event.getGender();

        AgeCategory ageCat = null;

        switch (ageCategory){
            case 0:
                ageCat = AgeCategory.child;
                break;
            case 1:
                ageCat = AgeCategory.adult;
                break;
            case 2:
                ageCat = AgeCategory.senior;
                break;
        }

        EmploymentCategory empCat;

        if (employmentCategory.equals("employed")){
            empCat=EmploymentCategory.employed;
        } else if (employmentCategory.equals("self_employed")){
            empCat=EmploymentCategory.self_employed;
        } else if (employmentCategory.equals("unemployed")){
            empCat=EmploymentCategory.unemployed;
        } else {
            empCat=EmploymentCategory.other;
        }

        Gender gender1;

        if (gender.equals("male")){
            gender1=Gender.male;
        } else {
            gender1=Gender.female;
        }

        Person person = new Person(name, occupation, ageCat, empCat, taxId, isUsCitizen, gender1);

        db.addPerson(person);
        System.out.println("Added to db: "+person.toString());
    }
}
