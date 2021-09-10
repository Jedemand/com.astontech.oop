package com.astontech.bo;

import java.util.Date;

public class EmployeeProject extends BaseBo {
    private int EmployeeProjectId;
    private Project ProjectName;
    private Employee EmployeeName;
    private EntityType ProjectType;
    private VehicleStatus VehicleType;
    private Date StartDate;
    private Date EndDate;
    private String Notes;

    //constructor
    public EmployeeProject() {
        this.ProjectName = new Project();
        this.EmployeeName = new Employee();
        this.ProjectType = new EntityType();
        this.VehicleType = new VehicleStatus();
    }

    public EmployeeProject(int employeeProjectId, Project projectName, Employee employeeName, EntityType projectType, VehicleStatus vehicleType, Date startDate, Date endDate, String notes) {
        EmployeeProjectId = employeeProjectId;
        ProjectName = projectName;
        EmployeeName = employeeName;
        ProjectType = projectType;
        VehicleType = vehicleType;
        StartDate = startDate;
        EndDate = endDate;
        Notes = notes;
    }

    //region get and set
    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }
    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public Project getProjectName() {
        return ProjectName;
    }
    public void setProjectName(Project projectName) {
        ProjectName = projectName;
    }

    public Employee getEmployeeName() {
        return EmployeeName;
    }
    public void setEmployeeName(Employee employeeName) {
        EmployeeName = employeeName;
    }

    public EntityType getProjectType() {
        return ProjectType;
    }
    public void setProjectType(EntityType projectType) {
        ProjectType = projectType;
    }

    public VehicleStatus getVehicleType() {
        return VehicleType;
    }
    public void setVehicleType(VehicleStatus vehicleType) {
        VehicleType = vehicleType;
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

    public String getNotes() {
        return Notes;
    }
    public void setNotes(String notes) {
        Notes = notes;
    }
    //endregion


}
