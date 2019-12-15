package com.example.demo.result;

public class PaperInsertResult {
    private int paperID;
    public PaperInsertResult(int id){
        this.paperID = id;
    }
    public int getPaperID() {
        return paperID;
    }

    public void setPaperID(int paperID) {
        this.paperID = paperID;
    }
}