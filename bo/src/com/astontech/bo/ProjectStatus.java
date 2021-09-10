package com.astontech.bo;

import java.util.Date;

public class ProjectStatus extends BaseBo{
    //parameters
    private int ProjectStatusId;
    private Project ProjectName;
    private EntityType StatusType;
    private String Notes;
    private int PercentComplete;
    private Date StartDate;
    private Date EndDate;

    //constructor
    public ProjectStatus() {
        this.ProjectName = new Project();
        this.StatusType = new EntityType();
    }

    //region get and set
    public int getProjectStatusId() {
        return ProjectStatusId;
    }
    public void setProjectStatusId(int projectStatusId) {
        ProjectStatusId = projectStatusId;
    }

    public Project getProjectName() {
        return ProjectName;
    }
    public void setProjectName(Project projectName) {
        ProjectName = projectName;
    }

    public EntityType getStatusType() {
        return StatusType;
    }
    public void setStatusType(EntityType statusType) {
        StatusType = statusType;
    }

    public String getNotes() {
        return Notes;
    }
    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }
    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
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
    //endregion
}
