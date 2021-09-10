package com.astontech.dao;

import com.astontech.bo.Person;

import java.util.List;

public interface PersonDAO {
    //Get method
    public Person getPersonById(int personId);
    public List<Person> getPersonList();

    //Execute Method
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public int deletePerson(int PersonId);
}
