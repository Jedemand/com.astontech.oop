package com.astontech.dao.mysql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQL {
    //DB connection string
    protected static String dbHost = "localhost";
    protected static String dbName = "astonengineer";
    protected static String dbUser = "root";
    protected static String dbPassword = "The-Dagda00";
    protected static String useSSL = "false";
    protected static String procBod = "true";


    protected static Connection connection = null;

    final static Logger logger = Logger.getLogger(MySQL.class);

    protected static final int GET_BY_ID = 10;
    protected static final int GET_COLLECTION = 20;
    protected static final int INSERT = 10;
    protected static final int UPDATE = 20;
    protected static final int DELETE = 30;

    //calls
    final static String getClient = "{call get_client(?, ?)}";

    final static String getEntityType = "{call get_entitytype(?, ?)}";

    final static String getEmail = "{call get_email(?, ?)}";
    final static String executeEmail = "{call execute_email(?, ?, ?, ?, ?)}";

    final static String getEmployee = "{call get_employee(?, ?)}";
    final static String executeEmployee = "{call execute_employee(?, ?, ?, ?, ?, ?)}";

    final static String getPerson = "{call get_person(?, ?)}";
    final static String executePerson = "{call execute_person(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    final static String getPhone = "{call get_phone(?, ?)}";
    final static String executePhone = "{call execute_phone(?, ?, ?, ?, ?, ?, ?, ?)}";

    final static String getVehicle = "{call get_vehicle(?, ?)}";
    final static String executeVehicle = "{call execute_vehicle(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    final static String getVehicleMake = "{call get_vehicleMake(?, ?)}";
    final static String executeVehicleMake = "{call execute_vehiclemake(?, ?, ?, ?)}";

    final static String getVehicleModel = "{call get_vehicleModel(?, ?)}";
    final static String executeVehicleModel = "{call execute_vehicleModel(?, ?, ?, ?)}";






    protected static void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Mysql driver not founder" + ex);
        }

        logger.info("MySQL Driver Registered");

       try{
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?autoReconnect=true&useSSL=" +useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPassword);
        } catch (
                SQLException ex){
            logger.error("Connection failed" + ex);
        }

        if(connection != null){
            logger.info("Successfully connected");
        } else{
            logger.info("Connection failed");
        }

    }


}
