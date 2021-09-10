package com.astontech.bo.interfaces;

public interface ITravel {

    //method to get cost. Returns int
    public double getCostOfTrip(int milesTraveled);

    //method to get time of travel returns int
    public int getTravelTime(int milesTraveled);

    //return owner
    public String getOwner();

}
