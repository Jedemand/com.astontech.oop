package com.astontech.bo;

import java.util.Date;

public class Training extends BaseBo{
    //parameters
    private int TrainingId;
    private Employee TrainedEmployee;
    private String EmployeeName;
    private Date CreateDate;

    //Constructor
    public Training() {
        this.TrainedEmployee = new Employee();
    }

    public Training(int trainingId, Employee trainedEmployee, String employeeName, Date createDate) {
        TrainingId = trainingId;
        TrainedEmployee = trainedEmployee;
        EmployeeName = employeeName;
        CreateDate = createDate;
    }

    //region get and set
    public int getTrainingId() {
        return TrainingId;
    }
    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public Employee getTrainedEmployee() {
        return TrainedEmployee;
    }
    public void setTrainedEmployee(Employee trainedEmployee) {
        TrainedEmployee = trainedEmployee;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }
    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }
    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion
}
