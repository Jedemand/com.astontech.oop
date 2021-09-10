package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO {
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getPerson;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                person = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<Person>();
        try{
            String storedProcedure = MySQL.getPerson;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                personList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person insertPerson) {
        Connect();
        int id = 0;
        try{
            String storedProcedure =  MySQL.getPerson;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, insertPerson.getTitle());
            cStmt.setString(4, insertPerson.getFirstName());
            cStmt.setString(5, insertPerson.getLastName());
            cStmt.setDate(6, DateHelper.utilDateToSQLDate(insertPerson.getCreateDate()));
            cStmt.setString(7, insertPerson.getDisplayFirstName());
            cStmt.setBoolean(8, insertPerson.getDeleted());
            cStmt.setString(9, insertPerson.getGender());
            

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
    public boolean updatePerson(Person updatePerson) {
        Connect();
        int id = 0;
        try{
            String storedProcedure =  MySQL.getPerson;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updatePerson.getPersonId());
            cStmt.setString(3, updatePerson.getTitle());
            cStmt.setString(4, updatePerson.getFirstName());
            cStmt.setString(5, updatePerson.getLastName());
            cStmt.setDate(6, DateHelper.utilDateToSQLDate(updatePerson.getCreateDate()));
            cStmt.setString(7, updatePerson.getDisplayFirstName());
            cStmt.setBoolean(8, updatePerson.getDeleted());
            cStmt.setString(9, updatePerson.getGender());


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
    public int deletePerson(int PersonId) {

        Connect();
        int id = 0;
        try{
            String storedProcedure = MySQL.getPerson;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, PersonId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setDate(6, new java.sql.Date(0));
            cStmt.setString(7, "");
            cStmt.setBoolean(8, false);
            cStmt.setString(9, "");


            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

               id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;

    }

    private static Person HydratingObject(ResultSet rs) throws SQLException{
          /*
         private int PersonId;
         private String Title;
         private String FirstName;
         private String LastName;
         private String DisplayFirstName;
         private String Gender;
         */
        Person person = new Person();
        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setLastName(rs.getString(4));
        person.setDisplayFirstName(rs.getString(5));
        person.setGender(rs.getString(6));

        return person;
    }

    private static Person ExecutingPerson(int personId, String title, String firstName, String lastName, String displayFirstName, String gender){
        Person person = new Person();
        person.setPersonId(personId);
        person.setTitle(title);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDisplayFirstName(displayFirstName);
        person.setGender(gender);

        return person;
    }

}
