package com.example.demo.entity;

public class Expert {
    private int expertID;
    private String expertName;
    private String institution;
    private String brief;
    private String technicalField;
    private String avatarUrl;
    private int paper_num;

    public int getPaper_num() {
        return paper_num;
    }

    public void setPaper_num(int paper_num) {
        this.paper_num = paper_num;
    }

    public int getexpertID() {
        return expertID;
    }

    public void setexpertID(int expertexpertID) {
        this.expertID = expertexpertID;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String gettechnicalField() {
        return technicalField;
    }

    public void settechnicalField(String technicalField) {
        this.technicalField = technicalField;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}