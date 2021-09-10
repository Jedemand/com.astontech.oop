package com.astontech.dao;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleDAO {
    public Vehicle getVehicleById(int vehicleId);
    public List<Vehicle> getVehicleList();

    //Execute Method
    public int insertVehicle(Vehicle vehicle, VehicleModel vehicleModel);
    public int updateVehicle(Vehicle vehicle, VehicleModel vehicleModel);
    public int deleteVehicle(Vehicle vehicle);
    
}
