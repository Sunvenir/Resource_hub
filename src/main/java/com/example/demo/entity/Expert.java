package com.example.demo.entity;

public class Expert {
    private static final String defAvatar = "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png";
    private int expertID;
    private String expertName;
    private String institution;
    private String brief;
    private String technicalField;
    private String avatarUrl;
    private int paperNum;
    private int patentNum;
    private int projectNum;
    private int ifidentification;

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
        if (avatarUrl == null || avatarUrl == "") {
            avatarUrl = defAvatar;
        }
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(int patentNum) {
        this.patentNum = patentNum;
    }

    public int getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public int getIsidentification() {
        return ifidentification;
    }

    public void setIsidentification(int isidentification) {
        this.ifidentification = isidentification;
    }

}