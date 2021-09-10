package com.astontech.dao.mysql;

import com.astontech.bo.EntityType;
import com.astontech.dao.EntityTypeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityTypeDAOImpl extends MySQL implements EntityTypeDAO {

    @Override
    public EntityType getEntityTypeById(int EntityTypeId) {
        Connect();
        EntityType entityType = null; //if not record is returned, don't use memory
        try{
            String storedProcedure = MySQL.getEntityType;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, EntityTypeId);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {

                entityType = HydratingObject(rs);

            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return entityType;
    }

    @Override
    public List<EntityType> getEntityTypeList() {
        Connect();
        List<EntityType> entityTypeList = new ArrayList<EntityType>();
        try{
            String storedProcedure = MySQL.getEntityType;
            CallableStatement cStmt = connection.prepareCall(storedProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //hydrating an object. Pouring data from database into object
                entityTypeList.add(HydratingObject(rs));
            }
        } catch(SQLException sqlException) {
            logger.error(sqlException);
        }

        return entityTypeList;
    }

    @Override
    public int insertEntityType(EntityType entityType) {
        return 0;
    }

    @Override
    public int updateEntityType(EntityType entityType) {
        return 0;
    }

    @Override
    public int deleteEntityType(EntityType entityType) {
        return 0;
    }

    private static EntityType HydratingObject(ResultSet rs) throws SQLException {

        EntityType entityType = new EntityType();
        entityType.setEntityTypeId(rs.getInt(1));
        entityType.setEntityTypeName(rs.getString(2));


        return entityType;
    }
}
