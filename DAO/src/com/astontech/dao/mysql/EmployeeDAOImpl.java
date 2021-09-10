package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.Employee;
import com.astontech.bo.Person;
import com.astontech.dao.EmployeeDAO;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends MySQL implements EmployeeDAO {

    @Override
    public Employee getEmployeeById(int EmployeeId) {
        Employee employee = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getEmployee;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, EmployeeId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                employee = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        Connect();
        List<Employee> employeeList = new ArrayList<Employee>();
        try{
            String storedProcedure = MySQL.getEmployee;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                employeeList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return employeeList;
    }

    @Override
    public int insertEmployee(Employee insertEmployee, Person personFK) {
        Connect();
        int id = 0;
      
        insertEmployee.setEmployeePerson(personFK);
       
        int PersonFK = GetPersonFK(personFK);
      

        try{
            String storedProcedure = MySQL.executeEmployee;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setDate(3, DateHelper.utilDateToSQLDate(insertEmployee.getHireDate()));
            cStmt.setDate(4, DateHelper.utilDateToSQLDate(insertEmployee.getTermDate()));
            cStmt.setDate(5, DateHelper.utilDateToSQLDate(insertEmployee.getBirthDate()));
            cStmt.setInt(6, PersonFK);
           
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
    public int updateEmployee(Employee updateEmployee, Person personFK) {

        Connect();
        int id = 0;

        updateEmployee.setEmployeePerson(personFK);

        int PersonFK = GetPersonFK(personFK);


        try{
            String storedProcedure = MySQL.executeEmployee;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updateEmployee.getEmployeeId());
            cStmt.setDate(3, DateHelper.utilDateToSQLDate(updateEmployee.getHireDate()));
            cStmt.setDate(4, DateHelper.utilDateToSQLDate(updateEmployee.getTermDate()));
            cStmt.setDate(5, DateHelper.utilDateToSQLDate(updateEmployee.getTermDate()));
            cStmt.setInt(6, PersonFK);

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
    public int deleteEmployee(int employeeId) {

        Connect();
        int id = 0;


        try{
            String storedProcedure = MySQL.executeEmployee;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, employeeId);
            cStmt.setDate(3, null);
            cStmt.setDate(4, null);
            cStmt.setDate(5, null);
            cStmt.setInt(6, 0);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    private static Employee HydratingObject(ResultSet rs) throws SQLException{
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt(1));
        employee.setHireDate(rs.getDate(2));
        employee.setTermDate(rs.getDate(3));
        employee.setBirthDate(rs.getDate(4));
        employee.setPersonId(rs.getInt(5));

        

        return employee;
    }

    private static int GetPersonFK(Person person) {
        int personFK = 0;
        PersonDAO getPersonFk = new PersonDAOImpl();
        List<Person> personList = getPersonFk.getPersonList();
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).getPersonId();
            if (personList.get(i).getPersonId() == person.getPersonId())
                personFK = personList.get(i).getPersonId();
        }
        return personFK;
    }
}
