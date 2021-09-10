package com.astontech.bo;

import java.util.Date;

public class TrainingData extends BaseBo{
    //parameters
    private int TrainingDataId;
    private Training TrainingId;
    private EntityType TrainingType;
    private String TrainingDataValue;
    private Date CreateDate;

    //constructor


    public TrainingData() {
        this.TrainingId = new Training();
        this.TrainingType = new EntityType();
    }

    public TrainingData(int trainingDataId, Training trainingId, EntityType trainingType, String trainingDataValue, Date createDate) {
        TrainingDataId = trainingDataId;
        TrainingId = trainingId;
        TrainingType = trainingType;
        TrainingDataValue = trainingDataValue;
        CreateDate = createDate;
    }


    //region get and set
    public int getTrainingDataId() {
        return TrainingDataId;
    }
    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public Training getTrainingId() {
        return TrainingId;
    }
    public void setTrainingId(Training trainingId) {
        TrainingId = trainingId;
    }

    public EntityType getTrainingType() {
        return TrainingType;
    }

    public void setTrainingType(EntityType trainingType) {
        TrainingType = trainingType;
    }

    public String getTrainingDataValue() {
        return TrainingDataValue;
    }
    public void setTrainingDataValue(String trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }
    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion
}
