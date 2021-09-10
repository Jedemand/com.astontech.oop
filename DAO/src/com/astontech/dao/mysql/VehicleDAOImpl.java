package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleDAO;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl extends MySQL implements VehicleDAO {


    @Override
    public Vehicle getVehicleById(int vehicleId) {
        Connect();
        Vehicle vehicle = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                vehicle = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        try{
            String storedProcedure = MySQL.getVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                vehicleList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle insertVehicle, VehicleModel insertModel) {
        Connect();
        int id = 0;
        insertVehicle.setVehicleModelId(insertModel);

        int foreignKey = GetIdNumber(insertModel);

        try{
            String storedProcedure = MySQL.executeVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, insertVehicle.getYear());
            cStmt.setString(4, insertVehicle.getLicensePlate());
            cStmt.setString(5, insertVehicle.getVIN());
            cStmt.setString(6, insertVehicle.getColor());
            cStmt.setBoolean(7, insertVehicle.isPurchased());
            cStmt.setInt(8, insertVehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSQLDate(insertVehicle.getPurchaseDate()));
            cStmt.setInt(10, foreignKey);


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
    public int updateVehicle(Vehicle updateVehicle, VehicleModel updateModel) {

        Connect();
        int id = 0;
        updateVehicle.setVehicleModelId(updateModel);

        int foreignKey = GetIdNumber(updateModel);

        try{
            String storedProcedure = MySQL.executeVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updateVehicle.getVehicleId());
            cStmt.setInt(3, updateVehicle.getYear());
            cStmt.setString(4, updateVehicle.getLicensePlate());
            cStmt.setString(5, updateVehicle.getVIN());
            cStmt.setString(6, updateVehicle.getColor());
            cStmt.setBoolean(7, updateVehicle.isPurchased());
            cStmt.setInt(8, updateVehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSQLDate(updateVehicle.getPurchaseDate()));
            cStmt.setInt(10, foreignKey);


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
    public int deleteVehicle(Vehicle deleteVehicle) {
        Connect();
        int id = 0;

        try{
            String storedProcedure = MySQL.executeVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, deleteVehicle.getVehicleId());
            cStmt.setInt(3, 0);
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setBoolean(7, false);
            cStmt.setInt(8, 0);
            cStmt.setDate(9, null);
            cStmt.setInt(10, 0);


            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
        
    }


    private static Vehicle HydratingObject(ResultSet rs) throws SQLException {
         
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(rs.getInt(1));
        vehicle.setYear(rs.getInt(2));
        vehicle.setLicensePlate(rs.getString(3));
        vehicle.setVIN(rs.getString(4));
        vehicle.setColor(rs.getString(5));
        vehicle.setPurchased(rs.getBoolean(6));
        vehicle.setPurchasePrice(rs.getInt(7));
        vehicle.setPurchaseDate(rs.getDate(8));
        
        return vehicle;
    }

    private static int GetIdNumber(VehicleModel vehicleModel){
        int foreignKey = 0;
        VehicleModelDAO getModelId = new VehicleModelDAOImpl();
        List<VehicleModel> modelList = getModelId.getVehicleModelList();
        for(int i = 0; i < modelList.size(); i++){
            modelList.get(i).getVehicleModelName();
            if(modelList.get(i).getVehicleModelName().equals(vehicleModel.getVehicleModelName()))
                foreignKey = modelList.get(i).getVehicleModelId();
        }
        return foreignKey;
    }
}
