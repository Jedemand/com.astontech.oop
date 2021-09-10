package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleMake;
import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleMakeAndModel;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VehicleMakeAndModelImpl extends MySQL implements VehicleMakeAndModel {
    @Override
    public ResultSet getVehicleById(int VehicleId) {
        Connect();
        Vehicle vehicle = null; //if not record is returned, don't use memory
        VehicleModel vehicleModel = null;
        VehicleMake vehicleMake = null;
        ResultSet rs = null;
        try {
            String storedProcedure = "{call get_vehicleMakeAndModel(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, VehicleId);

            rs = cStmt.executeQuery();

            if (rs.next()) {

                vehicle = HydratingVehicle(rs);
                vehicleModel = HydratingVehicleModel(rs);
                vehicleMake = HydratingVehicleMake(rs);


            }
        } catch (SQLException sqlException) {
            logger.error(sqlException);
        }

        return rs;
    }

    @Override
    public List<VehicleMakeAndModel> getVehicleMakeAndModelList() {
        return null;
    }

    @Override
    public int insertVehicleMakeAndModel(Vehicle insertVehicle, VehicleModel insertModel, VehicleMake insertMake) {
        Connect();
        int id = 0;
        insertModel.setVehicleMakeId(insertMake);
        insertVehicle.setVehicleModelId(insertModel);
        try{
            String storedProcedure = "{call execute_VehicleMakeandModel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, insertMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSQLDate(insertMake.getCreateDate()));

            cStmt.setInt(5, 0);
            cStmt.setString(6, insertModel.getVehicleModelName());
            cStmt.setInt(7, insertMake.getVehicleMakeId());

            cStmt.setInt(8, 0);
            cStmt.setInt(9, insertVehicle.getYear());
            cStmt.setString(10, insertVehicle.getLicensePlate());
            cStmt.setString(11, insertVehicle.getVIN());
            cStmt.setString(12, insertVehicle.getColor());
            cStmt.setBoolean(13, insertVehicle.isPurchased());
            cStmt.setInt(14, insertVehicle.getPurchasePrice());
            cStmt.setDate(15, DateHelper.utilDateToSQLDate(insertVehicle.getPurchaseDate()));
            cStmt.setInt(16, insertModel.getVehicleModelId());


            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    @Override
    public int updateVehicleMakeAndModel(Vehicle Vehicle) {
        return 0;
    }

    @Override
    public int deleteVehicleMakeAndModel(int VehicleId, int VehicleModelId, int VehicleMakeId) {
        return 0;
    }

    private static Vehicle HydratingVehicle(ResultSet rs) throws SQLException {

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(rs.getInt(8));
        vehicle.setYear(rs.getInt(9));
        vehicle.setLicensePlate(rs.getString(10));
        vehicle.setVIN(rs.getString(11));
        vehicle.setColor(rs.getString(12));
        vehicle.setPurchased(rs.getBoolean(13));
        vehicle.setPurchasePrice(rs.getInt(14));
        vehicle.setPurchaseDate(rs.getDate(15));
        return vehicle;
    }

    private static VehicleModel HydratingVehicleModel(ResultSet rs) throws SQLException{
        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleModelId(rs.getInt(5));
        vehicleModel.setVehicleModelName(rs.getString(6));

        return vehicleModel;
    }

    private static VehicleMake HydratingVehicleMake(ResultSet rs) throws SQLException{
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(2));
        vehicleMake.setVehicleMakeName(rs.getString(3));
        vehicleMake.setCreateDate(rs.getDate(4));

        return vehicleMake;
    }


}
