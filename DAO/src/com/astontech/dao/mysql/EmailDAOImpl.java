package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.*;
import com.astontech.dao.EmailDAO;
import com.astontech.dao.EmployeeDAO;
import com.astontech.dao.EntityTypeDAO;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl extends MySQL implements EmailDAO {
    @Override
    public Email getEmailById(int EmailId) {
       Connect();
       Email email  = null;
       try{
           String storedProcedure = MySQL.getEmail;
           CallableStatement cStmt = connection.prepareCall(storedProcedure);

           cStmt.setInt(1, GET_BY_ID);
           cStmt.setInt(2, EmailId);

           ResultSet rs = cStmt.executeQuery();

           if(rs.next()){
               email = HydratingObject(rs);
           }

       } catch(SQLException sqlException) {
           logger.error(sqlException);
       }
       return email;
    }

    @Override
    public List<Email> getEmailList() {
        Connect();
        List<Email> emailList = new ArrayList<Email>();
        try{
            String storedProcedure = MySQL.getEmail;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                emailList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return emailList;
    }

    @Override
    public int insertEmail(Email insertEmail, Employee employeeFK, EntityType entityTypeFK) {
        Connect();

        int EmployeeFK = GetEmployeeFK(employeeFK);
        int EntityTYpeFk = GetEntityFK(entityTypeFK);
        int id = 0;
        try{
            String storedProcedure = MySQL.executeEmail;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, insertEmail.getEmailAddress());
            cStmt.setInt(4, EmployeeFK);
            cStmt.setInt(5, EntityTYpeFk);


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
    public int updateEmail(Email updateEmail, Employee employeeFK, EntityType entityTypeFK) {

        Connect();

        int EmployeeFK = GetEmployeeFK(employeeFK);
        int EntityTYpeFk = GetEntityFK(entityTypeFK);
        int id = 0;
        try{
            String storedProcedure = MySQL.executeEmail;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updateEmail.getEmailId());
            cStmt.setString(3, updateEmail.getEmailAddress());
            cStmt.setInt(4, EmployeeFK);
            cStmt.setInt(5, EntityTYpeFk);



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
    public int deleteEmail(int EmailId) {
        Connect();


        int id = 0;
        try{
            String storedProcedure = MySQL.executeEmail;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, EmailId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);


            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    private static Email HydratingObject(ResultSet rs) throws SQLException {
        Email email = new Email();
        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));



        return email;
    }

    private static int GetEmployeeFK(Employee employee) {
        int employeeFK = 0;
        EmployeeDAO getEmployeeFk = new EmployeeDAOImpl();
        List<Employee> employeeList = getEmployeeFk.getEmployeeList();
        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.get(i).getEmployeeId();
            if (employeeList.get(i).getEmployeeId() == employee.getEmployeeId())
                employeeFK = employeeList.get(i).getEmployeeId();
        }
        return employeeFK;
    }

    private static int GetEntityFK(EntityType entityType) {
        int entityTypeFK = 0;
        EntityTypeDAO getEntityFK = new EntityTypeDAOImpl();
        List<EntityType> TypeList = getEntityFK.getEntityTypeList();
        for (int i = 0; i < TypeList.size(); i++) {
            TypeList.get(i).getEntityTypeName();
            if (TypeList.get(i).getEntityTypeId() == entityType.getEntityTypeId())
                entityTypeFK = TypeList.get(i).getEntityTypeId();
        }
        return entityTypeFK;
    }
}
