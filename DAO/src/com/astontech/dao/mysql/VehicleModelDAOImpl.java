package com.astontech.dao.mysql;


import Common.helpers.DateHelper;
import com.astontech.bo.VehicleMake;
import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleMakeDAO;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModelDAOImpl extends MySQL implements VehicleModelDAO {
    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {
        Connect();
        VehicleModel vehicleModel = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getVehicleModel;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                vehicleModel = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicleModel;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
        List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
        try{
            String storedProcedure = MySQL.getVehicleModel;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                vehicleModelList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicleModelList;
    }

    @Override
    public int insertVehicleModel(VehicleModel insertModel, VehicleMake insertMake) {
        Connect();
        int id = 0;
        insertModel.setVehicleMakeId(insertMake);

        int foreignKey = GetIdNumber(insertMake);

        try{
            String storedProcedure = MySQL.executeVehicleModel;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, insertModel.getVehicleModelName());
            cStmt.setInt(4, foreignKey);



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
    public boolean updateVehicleModel(VehicleModel updateModel, VehicleMake updateMake) {
        Connect();
        int id = 0;
        updateModel.setVehicleMakeId(updateMake);

        int foreignKey = GetIdNumber(updateMake);

        try{
            String storedProcedure = MySQL.executeVehicleModel;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updateModel.getVehicleModelId());
            cStmt.setString(3, updateModel.getVehicleModelName());
            cStmt.setInt(4, foreignKey);



            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id > 0;
    }

    @Override
    public int deleteVehicleModel(int vehicleModelId) {
        Connect();
        int id = 0;
                try{
            String storedProcedure = MySQL.executeVehicleModel;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, vehicleModelId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);



            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    private static VehicleModel HydratingObject(ResultSet rs) throws SQLException {

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelId(rs.getInt(1));
        vehicleModel.setVehicleModelName(rs.getString(2));

        return vehicleModel;
    }

    private static int GetIdNumber(VehicleMake vehicleMake){
        int foreignKey = 0;
        VehicleMakeDAO getMakeId = new VehicleMakeDAOImpl();
        List<VehicleMake> makeList = getMakeId.getVehicleMakeList();
        for (VehicleMake make : makeList) {
            if (make.getVehicleMakeName().equals(vehicleMake.getVehicleMakeName()))
                foreignKey = make.getVehicleMakeId();
        }
        return foreignKey;
    }
}
