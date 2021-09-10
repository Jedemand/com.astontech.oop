package com.astontech.bo;

public class Phone extends BaseBo{
    //parameters
    private int PhoneId;
    private EntityType PhoneType;
    private Client ClientPhone;
    private Person PersonPhone;
    private int AreaCode;
    private int PhoneNumber;
    private int PhoneNumberPost;

    //constructor
    public Phone() {
        this.PhoneType = new EntityType();
        this.ClientPhone = new Client();
        this.PersonPhone = new Person();
    }

    public Phone(int phoneId, EntityType phoneType, Client clientPhone, Person personPhone, int areaCode, int phoneNumber, int phoneNumberPost) {
        PhoneId = phoneId;
        PhoneType = phoneType;
        ClientPhone = clientPhone;
        PersonPhone = personPhone;
        AreaCode = areaCode;
        PhoneNumber = phoneNumber;
        PhoneNumberPost = phoneNumberPost;
    }

    //region getter and setter
    public int getPhoneId() {
        return PhoneId;
    }
    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public EntityType getPhoneType() {
        return PhoneType;
    }
    public void setPhoneType(EntityType phoneType) {
        PhoneType = phoneType;
    }

    public Client getClientPhone() {
        return ClientPhone;
    }
    public void setClientPhone(Client clientPhone) {
        ClientPhone = clientPhone;
    }

    public Person getPersonPhone() {
        return PersonPhone;
    }
    public void setPersonPhone(Person personPhone) {
        PersonPhone = personPhone;
    }

    public int getAreaCode() {
        return AreaCode;
    }
    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }
    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    public boolean MNNative(int areaCode){
        return areaCode == 612 ||areaCode == 218 || areaCode == 507 || areaCode == 952 || areaCode == 763 || areaCode == 651 || areaCode == 320;
    }
    //endregion
}
