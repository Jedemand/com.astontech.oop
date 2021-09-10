package com.astontech.bo.interfaces;

import com.astontech.bo.LoyaltyCompany;

public class Flight implements ITravel{
   private double CostPM;
   private int averageMPH;
   private LoyaltyCompany Company;

   //region constructor


    public Flight() {}

    public Flight(double costPm, int averageMPH, LoyaltyCompany company) {
        this.CostPM = costPm;
        this.averageMPH = averageMPH;
        Company = company;
    }


    // endregion

   //region getters and setters


    public double getCostPM() {
        return CostPM;
    }
    public void setCostPM(double costPM) {
        CostPM = costPM;
    }

    public int getAverageMPH() {
        return averageMPH;
    }

    public void setAverageMPH(int averageMPH) {
        this.averageMPH = averageMPH;
    }

    public LoyaltyCompany getCompany() {
        return Company;
    }

    public void setCompany(LoyaltyCompany company) {
        Company = company;
    }
    //endregion


    @Override
    public double getCostOfTrip(int miles) {
        return miles * CostPM;
    }

    @Override
    public int getTravelTime(int miles) {
       int time = miles / averageMPH;
       if (time < 24){
           return time;
       } else
           return time % 24;
    }

    @Override
    public String getOwner() {
        return Company.getCompanyName();
    }
}
