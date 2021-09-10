package com.astontech.dao;

import com.astontech.bo.EntityType;

import java.util.List;

public interface EntityTypeDAO {
    public EntityType getEntityTypeById(int EntityTypeId);

    public List<EntityType> getEntityTypeList();

    //Execute Method
    public int insertEntityType(EntityType entityType);
    public int updateEntityType(EntityType entityType);
    public int deleteEntityType(EntityType entityType);
}
