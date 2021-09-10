package com.astontech.bo;

public class ClientContact extends BaseBo{
    //parameters
    private int ClientContactId;
    private Client ClientName;
    private EntityType ContactType;

    //region constructors
    public ClientContact() {
        this.ContactType = new EntityType();
    }

    public ClientContact( Client clientName, EntityType contactType) {
        ClientName = clientName;
        ContactType = contactType;
    }
    //endregion

    //region get and set

    public int getClientContactId() {
        return ClientContactId;
    }
    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    public Client getClientName() {
        return ClientName;
    }
    public void setClientName(Client clientName) {
        ClientName = clientName;
    }

    public EntityType getContactType() {
        return ContactType;
    }
    public void setContactType(EntityType contactType) {
        ContactType = contactType;
    }
    //endregion
}
