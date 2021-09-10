package com.astontech.dao;

import com.astontech.bo.Client;
import com.astontech.bo.EntityType;
import com.astontech.bo.Person;
import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {
    public Phone getPhoneById(int phoneId);

    public List<Phone> getPhoneList();

    //Execute Method
    public int insertPhone(Phone phone, EntityType entityType, Person person, Client client);
    public int updatePhone(Phone phone, EntityType entityType, Person person, Client client);
    public int deletePhone(int phoneId);
    
}
