package com.astontech.bo;

public class EntityType extends BaseBo{
    //parameters
    private int EntityTypeId;
    private String EntityTypeName;
    private Entity EntityName;

    // region constructor


    public EntityType() {
        this.EntityName = new Entity();
    }

    public EntityType(String entityTypeName) {
        this.EntityTypeName = entityTypeName;
    }
    //endregion

    //region get and set
    public int getEntityTypeId() {
        return EntityTypeId;
    }
    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }
    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }

    public Entity getEntityName() {
        return EntityName;
    }
    public void setEntityName(Entity entityName) {
        EntityName = entityName;
    }

//endregion

    //Overridden Method
    public String test_method(){
        return "polymorphism!";
    }
}
