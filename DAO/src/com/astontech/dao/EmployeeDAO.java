package com.astontech.dao;

import com.astontech.bo.Employee;
import com.astontech.bo.Person;


import java.util.List;

public interface EmployeeDAO {
    //Get method
    public Employee getEmployeeById(int EmployeeId);
    public List<Employee> getEmployeeList();

    //Execute Method
    public int insertEmployee(Employee employee, Person person);
    public int updateEmployee(Employee employee, Person person);
    public int deleteEmployee(int employeeId);
}
