package com.astontech.bo;

import java.util.Date;

public class Client {
    //parameters
    int ClientId;
    String ClientName;
    Date CreateDate;

    //constructor


    public Client() {
    }

    public Client(int clientId, String clientName, Date createDate) {
        ClientId = clientId;
        ClientName = clientName;
        CreateDate = createDate;
    }

    //get and set

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
