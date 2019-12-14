package com.example.demo.entity;

public class Relationship_project {
    private int expertID;
    private int projectID;

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setExpertID(int expertID) {
        this.expertID = expertID;
    }

    public int getExpertID() {
        return expertID;
    }
}
