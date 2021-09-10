package com.astontech.bo;

import java.util.Date;

public class Employee extends Person{
    //Attributes/Parameters
    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;
    private Date BirthDate;
    private Person EmployeePerson;




    //constructors
    public Employee(){}

    public  Employee(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    public Employee(int employeeId, Date hireDate, Date termDate, Date BirthDate, Person EmployeePerson){
        this.setEmployeeId(employeeId);
        this.setHireDate(hireDate);
        this.setTermDate(termDate);
        this.setBirthDate(BirthDate);
        this.setEmployeePerson(EmployeePerson);
    }
    public Employee(int employeeId, String firstname){
        this.setFirstName(firstname);
    }

    public Employee(String lastname){
        this.setLastName(lastname);
    }

    //getter/setters
    public void setEmployeeId(int employeeId){
       this.EmployeeId = employeeId;
    }
    
    public int getEmployeeId(){
        return this.EmployeeId;
    }

    public void setHireDate(Date hireDate){
        this.HireDate = hireDate;
    }

    public Date getHireDate(){
        return this.HireDate;
    }

    public void setTermDate(Date termDate){
        this.TermDate = termDate;
    }

    public Date getTermDate(){
        return this.TermDate;
    }


    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Person getEmployeePerson() {
        return EmployeePerson;
    }

    public void setEmployeePerson(Person employeePerson) {
        EmployeePerson = employeePerson;
    }
}
