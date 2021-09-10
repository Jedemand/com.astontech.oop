package com.astontech.dao;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;
import com.astontech.bo.VehicleMake;

import java.sql.ResultSet;
import java.util.List;

public interface VehicleMakeAndModel {
    public ResultSet getVehicleById(int VehicleId);

    public List<VehicleMakeAndModel> getVehicleMakeAndModelList();

    //Execute Method
    public int insertVehicleMakeAndModel(Vehicle Vehicle, VehicleModel vehicleModel, VehicleMake vehicleMake);
    public int updateVehicleMakeAndModel(Vehicle Vehicle);
    public int deleteVehicleMakeAndModel(int VehicleId, int VehicleModelId, int VehicleMakeId);
}
