package com.example.demo.entity;

public class Expert {
    private int ID;
    private String expertName;
    private String institution;
    private String brief;
    private String field;
    private String avatarUrl;
    private int paper_num;
    private boolean iden;

    public int getPaper_num() {
        return paper_num;
    }

    public void setPaper_num(int paper_num) {
        this.paper_num = paper_num;
    }

    public int getID() {
        return ID;
    }

    public void setID(int expertID) {
        this.ID = expertID;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isIden() {
        return iden;
    }

    public void setIden(boolean iden) {
        this.iden = iden;
    }

}