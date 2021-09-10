package com.astontech.dao;

import com.astontech.bo.VehicleMake;
import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleModelDAO {
    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();

    //Execute Method
    public int insertVehicleModel(VehicleModel vehicleModel, VehicleMake vehicleMake);
    public boolean updateVehicleModel(VehicleModel vehicleModel, VehicleMake vehicleMake);
    public int deleteVehicleModel(int vehicleModelId);
}
