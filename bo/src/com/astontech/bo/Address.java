package com.astontech.bo;

import java.util.Date;

public class Address extends BaseBo{
    //parameters
    private int AddressId;
    private Client ClientName;
    private Person PersonName;
    private EntityType AddressType;
    private int AddressNumber;
    private String Street;
    private String Street2;
    private String City;
    private int StateId;
    private int CountryId;
    private Date DateCreate;

    //constructors
    public Address() {
        this.AddressType = new EntityType();
        this.ClientName = new Client();
        this.PersonName = new Person();
    }

    public Address(Client clientName, int addressNumber, String street, String street2, String city, int stateId, int countryId) {
        ClientName = clientName;
        AddressNumber = addressNumber;
        Street = street;
        Street2 = street2;
        City = city;
        StateId = stateId;
        CountryId = countryId;
    }

    public Address(Person personName, int addressNumber, String street, String street2, String city, int stateId, int countryId) {
        PersonName = personName;
        AddressNumber = addressNumber;
        Street = street;
        Street2 = street2;
        City = city;
        StateId = stateId;
        CountryId = countryId;
    }


    //get and set
    public void setAddressId(int addressId) {
        AddressId = addressId;
    }
    public int getAddressId() {
        return AddressId;
    }

    public Client getClientName() {
        return ClientName;
    }
    public void setClientName(Client clientName) {
        ClientName = clientName;
    }

    public Person getPersonName() {
        return PersonName;
    }
    public void setPersonName(Person personName) {
        PersonName = personName;
    }

    public EntityType getAddressType() {
        return AddressType;
    }

    public void setAddressType(EntityType addressType) {
        AddressType = addressType;
    }

    public void setAddressNumber(int addressNumber) {
        AddressNumber = addressNumber;
    }
    public int getAddressNumber() {
        return AddressNumber;
    }


    public void setStreet(String street) {
        Street = street;
    }
    public String getStreet() {
        return Street;
    }

    public void setStreet2(String street2) {
        Street2 = street2;
    }
    public String getStreet2() {
        return Street2;
    }

    public void setCity(String city) {
        City = city;
    }
    public String getCity() {
        return City;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }
    public int getStateId() {
        return StateId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }
    public int getCountryId() {
        return CountryId;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }
    public Date getDateCreate() {
        return DateCreate;
    }


}
