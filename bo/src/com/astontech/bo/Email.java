package com.astontech.bo;

public class Email {
    //region parameters
    private int EmailId;
    private String EmailAddress;
    private Employee EmployeeId;
    private EntityType EmailType;
    //endregion

    //region constructor
    public Email() {
        this.EmailType = new EntityType();
    }

    public Email(int emailId, String emailAddress, Employee employeeId, EntityType emailType) {
        EmailId = emailId;
        EmailAddress = emailAddress;
        EmployeeId = employeeId;
        EmailType = emailType;
    }

    public Email(String emailAddress){
        this.EmailType = new EntityType();
        this.EmailAddress = emailAddress;
    }

    //end region

    //region get and set
    public int getEmailId() {
        return EmailId;
    }
    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public Employee getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        EmployeeId = employeeId;
    }

    public EntityType getEmailType() {return EmailType;}
    public void setEmailType(EntityType emailType ) {
        EmailType = emailType;
    }
    //endregion

}
