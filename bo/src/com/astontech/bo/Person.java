package com.astontech.bo;

import Common.helpers.StringHelper;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person extends BaseBo implements Comparable, Serializable {

    //region Parameters
    private int PersonId;
    private String Title;
    private String FirstName;
    private String LastName;
    private java.util.Date CreateDate;
    private String DisplayFirstName;
    private Boolean IsDeleted;
    private String Gender;
    //list of email objects
    private List<Email> Emails;
    private List<Vehicle> Vehicles;


//endregion

    //region constructor
    public Person() {
        this.Emails = new ArrayList<>();
        this.Vehicles = new ArrayList<>();
    }

    public Person(int personId) {
        PersonId = personId;
    }

    public Person(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public Person(int personId, String title, String firstName, String lastName, java.util.Date createDate, String displayFirstName, Boolean isDeleted, String gender) {
        PersonId = personId;
        Title = title;
        FirstName = firstName;
        LastName = lastName;
        CreateDate = createDate;
        DisplayFirstName = displayFirstName;
        IsDeleted = isDeleted;
        Gender = gender;
    }

    public Person(int personId, String title, String firstName, String lastName, String displayFirstName, String gender) {
        PersonId = personId;
        Title = title;
        FirstName = firstName;
        LastName = lastName;
        DisplayFirstName = displayFirstName;
        Gender = gender;
    }
    //endregion

    //region get and set
    public void setPersonId(int personId){
        this.PersonId = personId;
    }
    public int getPersonId(){
        return this.PersonId;
    }
    public void setTitle(String title){
        this.Title = title;
    }
    public String getTitle(){
        return this.Title;
    }
    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }
    public String getFirstName(){
        return this.FirstName;
    }
    public void setLastName(String lastname){
        this.LastName = lastname;
    }
    public String getLastName(){
        return this.LastName;
    }
    public void setDisplayFirstName(String displayfirstname){
        this.DisplayFirstName = displayfirstname;
    }
    public String getDisplayFirstName(){
        return this.DisplayFirstName;
    }
    public void setGender(String gender){
        this.Gender = gender;
    }
    public String getGender(){
        return this.Gender;
    }

    public List<Email> getEmails() {
        return this.Emails;
    }
    public void setEmails(List<Email> emailList) {
        this.Emails = emailList;
    }

    public List<Vehicle> getVehicles() {
        return Vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        Vehicles = vehicles;
    }

    public java.util.Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        CreateDate = createDate;
    }

    public Boolean getDeleted() {
        return IsDeleted;
    }

    public void setDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }


    //endregion


    //custom methods

    public String toString(){
        return "personId: " + this.getPersonId() + " Full Name: " + this.GetFullName() + " Date of Birth: " + this.getCreateDate() + "Gender:" + this.getGender() + ".";
    }
    public String GetFullName(){
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No name set.";
        else{
            if(StringHelper.isNullOrEmpty(this.FirstName))
                return this.LastName;
            else if(StringHelper.isNullOrEmpty(this.LastName))
                return this.FirstName;
            else
                return this.FirstName + " " + this.LastName;
        }

    }

    @Override
    public int compareTo(Object temp)
    {
        Person other = (Person) temp;
        int compare = getLastName().compareTo(other.getLastName());
        if(compare < 0){
            return 1;
        } else if (compare > 0){
            return -1;
        } else
            return 0;
    }
}
