package com.astontech.bo;

import java.util.Date;

public class Project extends BaseBo{
    //parameters
    private int ProjectId;
    private Client ProjectClient;
    private EntityType ProjectType;
    private String Rate;
    private Date StartDate;
    private Date EndDate;
    private String ProjectName;

    //constructor
    public Project() {
        this.ProjectClient = new Client();
        this.ProjectType = new EntityType();
    }

    public Project(int projectId, Client projectClient, EntityType projectType, String rate, Date startDate, Date endDate, String projectName) {
        ProjectId = projectId;
        ProjectClient = projectClient;
        ProjectType = projectType;
        Rate = rate;
        StartDate = startDate;
        EndDate = endDate;
        ProjectName = projectName;
    }

    //region get and set
    public int getProjectId() {
        return ProjectId;
    }
    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public Client getProjectClient() {
        return ProjectClient;
    }

    public void setProjectClient(Client projectClient) {
        ProjectClient = projectClient;
    }

    public EntityType getProjectType() {
        return ProjectType;
    }

    public void setProjectType(EntityType projectType) {
        ProjectType = projectType;
    }

    public String getRate() {
        return Rate;
    }
    public void setRate(String rate) {
        Rate = rate;
    }

    public Date getStartDate() {
        return StartDate;
    }
    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }
    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getProjectName() {
        return ProjectName;
    }
    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
    //endregion
}
