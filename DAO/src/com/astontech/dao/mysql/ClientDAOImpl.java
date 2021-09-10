package com.astontech.dao.mysql;

import com.astontech.bo.Client;
import com.astontech.bo.Phone;
import com.astontech.dao.ClientDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends MySQL implements ClientDAO {
    @Override
    public Client getClientById(int ClientId) {
        Connect();
        Client client = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = "{call get_client(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, ClientId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                client = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return client;
    }

    @Override
    public List<Client> getClientList() {
        Connect();
        List<Client> clientList = new ArrayList<Client>();
        try{
            String storedProcedure = "{call get_client(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                clientList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return clientList;
    }

    @Override
    public int insertClient(Client client) {
        return 0;
    }

    @Override
    public int updateClient(Client client) {
        return 0;
    }

    @Override
    public int deleteClient(Client client) {
        return 0;
    }

    private static Client HydratingObject(ResultSet rs) throws SQLException{

        Client client = new Client();
       client.setClientId(rs.getInt(1));
       client.setClientName(rs.getString(2));
       client.setCreateDate(rs.getDate(3));

        return client;
    }

}
