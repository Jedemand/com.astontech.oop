package com.astontech.bo.interfaces;



public class Site implements ILocation {

    private int ConferenceRooms;
    private int Offices;
    private int Cubicles;
    private int TrainingDesks;
    private int CoffeeMachine;
    private String SiteName;

    //region get and set


    public int getConferenceRooms() {
        return ConferenceRooms;
    }
    public void setConferenceRooms(int conferenceRooms) {
        ConferenceRooms = conferenceRooms;
    }

    public int getOffices() {
        return Offices;
    }
    public void setOffices(int offices) {
        Offices = offices;
    }

    public int getCubicles() {
        return Cubicles;
    }
    public void setCubicles(int cubicles) {
        Cubicles = cubicles;
    }

    public int getCoffeeMachine() {
        return CoffeeMachine;
    }
    public void setCoffeeMachine(int coffeeMachine) {
        CoffeeMachine = coffeeMachine;
    }

    public String getSiteName() {
        return SiteName;
    }
    public void setSiteName(String siteName) {
        SiteName = siteName;
    }
    //endregion

    @Override
    public int numberOfWorkspaces(){
        return (this.Cubicles + this.Offices + this.TrainingDesks);
    }

    @Override
    public boolean canHAveMeetings(){
        return (this.ConferenceRooms >= 1);
    }

    @Override
    public String getLocationName(){
        return (this.SiteName);
    }

    @Override
    public boolean hasCoffee(){
        return (this.CoffeeMachine >= 1);
    }
}
