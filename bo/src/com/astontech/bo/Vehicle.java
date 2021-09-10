package com.astontech.bo;

import java.util.Date;

public class Vehicle extends BaseBo implements Comparable{
    //parameters
    private int VehicleId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private boolean IsPurchased;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleModel VehicleModelId;

    //constructor


    public Vehicle() {
        this.VehicleModelId = new VehicleModel();
    }

    public Vehicle(int vehicleId, int year, String licensePlate, String VIN, String color, boolean isPurchased, int purchasePrice, Date purchaseDate, VehicleModel vehicleModelId) {
        VehicleId = vehicleId;
        Year = year;
        LicensePlate = licensePlate;
        this.VIN = VIN;
        Color = color;
        IsPurchased = isPurchased;
        PurchasePrice = purchasePrice;
        PurchaseDate = purchaseDate;
        VehicleModelId = vehicleModelId;
    }

    //region get and set
    public int getVehicleId() {
        return VehicleId;
    }
    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }
    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }
    public void setColor(String color) {
        Color = color;
    }

    public boolean isPurchased() {
        return IsPurchased;
    }
    public boolean setPurchased(boolean purchased) {
        IsPurchased = purchased;
        return purchased;
    }


    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }


    public VehicleModel getVehicleModelId() {
        return VehicleModelId;
    }
    public void setVehicleModelId(VehicleModel vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }
    //endregion

    //methods
    public boolean IsAvailableToBuy(){
        return this.IsPurchased;
    }

    public void IsThisCarTooOld(int YearYouWereBorn){
        if(YearYouWereBorn > this.Year)
            System.out.println("This car is probably too old");
        else
            System.out.println("Its maybe fine");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleId= " + VehicleId +
                ", Year= " + Year +
                ", LicensePlate= '" + LicensePlate + '\'' +
                ", VIN= '" + VIN + '\'' +
                ", Color= '" + Color + '\'' +
                ", IsPurchased= " + IsPurchased +
                ", PurchaseDate= " + PurchaseDate +
                ", VehicleModelId= " + VehicleModelId.getVehicleModelName() +
                ", VehicleMake= " + VehicleModelId.getVehicleMakeId().getVehicleMakeName()+
                '}';
    }

    @Override
    public int compareTo(Object temp) {
        Vehicle other = (Vehicle) temp;

        if(getYear() > other.getYear()){
            return 1;
        } else if(getYear() < other.getYear()){
            return -1;
        }else
            return 0;
    }
}

