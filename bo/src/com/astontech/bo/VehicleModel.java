package com.astontech.bo;

public class VehicleModel extends BaseBo{
    //parameters
    private int VehicleModelId;
    private String VehicleModelName;
    private VehicleMake VehicleMakeId;

    //constructor

    public VehicleModel() {
        this.VehicleMakeId = new VehicleMake();
    }

    public VehicleModel(String vehicleModelName, VehicleMake vehicleMakeId) {
        VehicleModelName = vehicleModelName;
        VehicleMakeId = vehicleMakeId;
    }

    public VehicleModel(int vehicleModelId, String vehicleModelName, VehicleMake vehicleMakeId) {
        VehicleModelId = vehicleModelId;
        VehicleModelName = vehicleModelName;
        VehicleMakeId = vehicleMakeId;
    }

    //region get and set
    public int getVehicleModelId() {
        return VehicleModelId;
    }
    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }
    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMakeId() {
        return VehicleMakeId;
    }
    public void setVehicleMakeId(VehicleMake vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }
    //endregion
}
