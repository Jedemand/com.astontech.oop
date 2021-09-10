package com.astontech.bo;

public class Entity extends BaseBo{
    //attributes
    private int EntityId;
    private String EntityName;

    //Constructors
    public Entity(){}

    public Entity(int entityId,String entityName){
        this.setEntityId(entityId);
        this.setEntityName(entityName);
    }

    //get and set

    public void setEntityId(int entityId) {
        this.EntityId = entityId;
    }

    public int getEntityId(){
        return this.EntityId;
    }

    public void setEntityName(String entityName) {
        this.EntityName = entityName;
    }

    public String getEntityName(){
        return this.EntityName;
    }
}
