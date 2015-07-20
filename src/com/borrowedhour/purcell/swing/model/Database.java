package com.borrowedhour.purcell.swing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borrowedhour on 7/20/15.
 */
public class Database {

    private ArrayList<Person> people;

    public Database() {
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }
}
