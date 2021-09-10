package com.astontech.bo.interfaces;

import com.astontech.bo.LoyaltyCompany;
import com.astontech.bo.Person;

public class CarTrip implements ITravel{
    private double PricePerGallon;
    private int MilesPerGallon;
    private int AverageMPH;
    private LoyaltyCompany Company;
    private Person Owner;

    //region constructors

    public CarTrip() {
    }

    public CarTrip(int pricePerGallon, int milesPerGallon, int averageMPH, LoyaltyCompany company) {
        PricePerGallon = pricePerGallon;
        MilesPerGallon = milesPerGallon;
        AverageMPH = averageMPH;
        Company = company;
    }

    public CarTrip(double pricePerGallon, int milesPerGallon, int averageMPH, Person owner) {
        PricePerGallon = pricePerGallon;
        MilesPerGallon = milesPerGallon;
        AverageMPH = averageMPH;
        Owner = owner;
    }

    //endregion

     //region get and set

    public double getPricePerGallon() {
        return PricePerGallon;
    }

    public void setPricePerGallon(double pricePerGallon) {
        PricePerGallon = pricePerGallon;
    }

    public int getMilesPerGallon() {
        return MilesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        MilesPerGallon = milesPerGallon;
    }

    public int getAverageMPH() {
        return AverageMPH;
    }

    public void setAverageMPH(int averageMPH) {
        AverageMPH = averageMPH;
    }

    public LoyaltyCompany getCompany() {
        return Company;
    }

    public void setCompany(LoyaltyCompany company) {
        Company = company;
    }

    public void setOwner(Person owner) {
        Owner = owner;
    }


    //endregion


    @Override
    public double getCostOfTrip(int milesTraveled) {
        return (milesTraveled/MilesPerGallon) * PricePerGallon;
    }

    @Override
    public int getTravelTime(int milesTraveled) {
        int time = milesTraveled / AverageMPH;
        if (time < 24){
            return time;
        } else
            return time % 24;
    }

    @Override
    public String getOwner() {
        if(Company != null){
            return Company.getCompanyName();
        } else if (Owner != null){
            return Owner.GetFullName();
        }else
            return "No one owns this vehicle. Claim it by right of salvage";
    }
}
