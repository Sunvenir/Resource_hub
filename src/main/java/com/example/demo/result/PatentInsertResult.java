package com.example.demo.result;

public class PatentInsertResult {
    private int patentID;
    public PatentInsertResult(int id)
    {
        this.patentID = id;
    }

    public int getPatentID() {
        return patentID;
    }

    public void setPatentID(int patentID) {
        this.patentID = patentID;
    }
}
