package com.concerno.dto;

import java.time.LocalDate;

public class ComplaintDTO {
    private Long complainId;
    private String description;
    private String status;
    private String department;
    private LocalDate dateOfIncident;

    private String concernedCitizen;
    private String mobileNumber;
    private String location;

    public ComplaintDTO(){
        this.dateOfIncident = LocalDate.now();
        this.status = "Pending...";
    }

    public Long getComplainId() {
        return complainId;
    }

    public void setComplainId(Long complainId) {
        this.complainId = complainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDateOfIncident() {
        return dateOfIncident;
    }

    public void setDateOfIncident() {
        this.dateOfIncident = LocalDate.now();
    }

    public String getConcernedCitizen() {
        return concernedCitizen;
    }

    public void setConcernedCitizen(String concernedCitizen) {
        this.concernedCitizen = concernedCitizen;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
