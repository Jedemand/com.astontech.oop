package com.astontech.dao.mysql;

import Common.helpers.DateHelper;
import com.astontech.bo.*;

import com.astontech.dao.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl extends MySQL implements PhoneDAO {

    @Override
    public Phone getPhoneById(int phoneId) {
        Connect();
        Phone phone = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getPhone;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, phoneId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                phone = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return phone;
    }

    @Override
    public List<Phone> getPhoneList() {
        Connect();
        List<Phone> phoneList = new ArrayList<Phone>();
        try{
            String storedProcedure = MySQL.getPhone;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                phoneList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return phoneList;
    }

    @Override
    public int insertPhone(Phone insertPhone, EntityType typeFK, Person personFK, Client clientFK) {
        Connect();
        int id = 0;
        insertPhone.setPhoneType(typeFK);
        insertPhone.setPersonPhone(personFK);
        insertPhone.setClientPhone(clientFK);

        int EntityFK = GetEntityFK(typeFK);
        int PersonFK = GetPersonFK(personFK);
        int ClientFK = GetClientFK(clientFK);

        try{
            String storedProcedure = MySQL.executePhone;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, EntityFK);
            cStmt.setInt(4, PersonFK);
            cStmt.setInt(5, ClientFK);
            cStmt.setInt(6, insertPhone.getAreaCode());
            cStmt.setInt(7, insertPhone.getPhoneNumber());
            cStmt.setInt(8, insertPhone.getPhoneNumberPost());


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
    public int updatePhone(Phone updatePhone, EntityType typeFK, Person personFK, Client clientFK) {
        Connect();
        int id = 0;
        updatePhone.setPhoneType(typeFK);
        updatePhone.setPersonPhone(personFK);
        updatePhone.setClientPhone(clientFK);

        int EntityFK = GetEntityFK(typeFK);
        int PersonFK = GetPersonFK(personFK);
        int ClientFK = GetClientFK(clientFK);

        try{
            String storedProcedure = MySQL.executePhone;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, updatePhone.getPhoneId());
            cStmt.setInt(3, EntityFK);
            cStmt.setInt(4, PersonFK);
            cStmt.setInt(5, ClientFK);
            cStmt.setInt(6, updatePhone.getAreaCode());
            cStmt.setInt(7, updatePhone.getPhoneNumber());
            cStmt.setInt(8, updatePhone.getPhoneNumberPost());


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
    public int deletePhone(int phoneId) {
        Connect();
        int id = 0;


        try{
            String storedProcedure = MySQL.executePhone;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, phoneId);
            cStmt.setInt(3, 0);
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);
            cStmt.setInt(6, 0);
            cStmt.setInt(7, 0);
            cStmt.setInt(8, 0);


            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt(1);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return id;
    }

    private static Phone HydratingObject(ResultSet rs) throws SQLException{

        Phone phone = new Phone();
        phone.setPhoneId(rs.getInt(1));
        phone.setAreaCode(rs.getInt(5));
        phone.setPhoneNumber(rs.getInt(6));
        phone.setPhoneNumberPost(rs.getInt(7));

        return phone;
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

    private static int GetClientFK(Client client) {
        int ClientFK = 0;
        ClientDAO getClientFK = new ClientDAOImpl();
        List<Client> clientList = getClientFK.getClientList();
        for (int i = 0; i < clientList.size(); i++) {
            clientList.get(i).getClientId();
            if (clientList.get(i).getClientId() == client.getClientId())
                ClientFK = clientList.get(i).getClientId();

        }
        return  ClientFK;
        }
}



