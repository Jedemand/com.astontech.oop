package com.astontech.dao;

import com.astontech.bo.Email;
import com.astontech.bo.Employee;
import com.astontech.bo.EntityType;

import java.util.List;

public interface EmailDAO {
    public Email getEmailById(int EmailId);

    public List<Email> getEmailList();

    //Execute Method
    public int insertEmail(Email email, Employee employee, EntityType entityType);
    public int updateEmail(Email email, Employee employee, EntityType entityType);
    public int deleteEmail(int EmailId);
}
