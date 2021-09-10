package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {
    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                vehicleMake = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
        List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();
        try{
            String storedProcedure = MySQL.getVehicle;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                vehicleMakeList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return vehicleMakeList;
    }

    @Override
    public int insertVehicleMake(VehicleMake insertMake) {
        Connect();
        int id = 0;
        try{
            String storedProcedure = MySQL.executeVehicleMake;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, insertMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSQLDate(insertMake.getCreateDate()));

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
    public boolean updateVehicleMake(VehicleMake updateVehicle) {
        Connect();
        int id = 0;
        try{
            String storedProcedure = MySQL.executeVehicleMake;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updateVehicle.getVehicleMakeId());
            cStmt.setString(3, updateVehicle.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSQLDate(updateVehicle.getCreateDate()));

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
    public int deleteVehicleMake(int vehicleMakeId) {
        Connect();
        int id = 0;
        try{
            String storedProcedure = MySQL.executeVehicleMake;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, vehicleMakeId);
            cStmt.setString(3, "");
            cStmt.setDate(4, null);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    private static VehicleMake HydratingObject(ResultSet rs) throws SQLException {

        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
       
        return vehicleMake;
    }
}
