package com.astontech.dao;

import com.astontech.bo.Client;

import java.util.List;

public interface ClientDAO {
    public Client getClientById(int ClientId);

    public List<Client> getClientList();

    //Execute Method
    public int insertClient(Client client);
    public int updateClient(Client client);
    public int deleteClient(Client client);
}
