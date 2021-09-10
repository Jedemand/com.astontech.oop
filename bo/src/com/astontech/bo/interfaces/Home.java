package com.astontech.bo.interfaces;

import com.astontech.bo.Employee;

public class Home implements ILocation{
    private String Address;
    private Employee Owner;
    private int CoffeeMachine;

    //region Getter and Setter
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        Owner = owner;
    }

    public int getCoffeeMachine() {
        return CoffeeMachine;
    }

    public void setCoffeeMachine(int coffeeMachine) {
        CoffeeMachine = coffeeMachine;
    }


    //endregion


    @Override
    public int numberOfWorkspaces() {
        return 1;
    }

    @Override
    public boolean canHAveMeetings() {
        return false;
    }

    @Override
    public String getLocationName() {
       return this.Owner.getFirstName() + "'s House";
    }

    @Override
    public boolean hasCoffee() {
        return (this.CoffeeMachine >= 1);
    }

}
