package com.example.demo.entity;

public class Patent
{
    private int patentID;
    private String patentName;
    private String applicationDate;
    private String authorizationDate;
    private String patentNumber;
    private String brief;
    private String patentType;
    private String patentAuthor;

    public int getPatentID(){return this.patentID;}

    public void setPatentID(int patentID){this.patentID = patentID;}

    public String getPatentName(){return this.patentName;}

    public void setPatentName(String name){this.patentName = name;}

    public String getApplicationDate(){return this.applicationDate;}

    public void setApplicationDate(String date){this.applicationDate = date;}

    public String getAuthorizationDate(){return this.authorizationDate;}

    public void setAuthorizationDate(String date){this.authorizationDate = date;}

    public String getPatentNumber(){return this.patentNumber;}

    public void setPatentNumber(String num){this.patentNumber = num;}

    public String getBrief(){return this.brief;}

    public void setBrief(String brief){this.brief = brief;}

    public String getPatentType(){return this.patentType;}

    public void setPatentType(String type){this.patentType = type;}

    public String getPatentAuthor(){return this.patentAuthor;}

    public void setPatentAuthor(String author){this.patentAuthor = author;}
}
