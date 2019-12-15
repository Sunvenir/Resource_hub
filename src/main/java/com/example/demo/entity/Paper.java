package com.example.demo.entity;

public class Paper
{
    private static int PaperID = 1;
    private String paperName;
    private String downloadLink;
    private String ISBN;
    private String date;
    private String source;
    private String keywords;
    private String paperType;
    private String _abstract;
    private String author;

    public Paper()
    {
        PaperID ++;
    }
    public int getPaperID(){return this.PaperID;}

    public String getPaperName(){return this.paperName;}
    public void setPaperName(String paperName){this.paperName = paperName;}

    public String getDownloadLink(){return this.downloadLink;}
    public void setDownloadLink(String downloadLink){this.downloadLink = downloadLink;}

    public String getISBN(){return this.ISBN;}
    public void setISBN(String ISBN){this.ISBN = ISBN;}

    public String getDate(){return this.date;}
    public void setDate(String date){ this.date = date;}
    
    public String getSource(){return this.source;}
    public void setSource(String source){this.source = source;}

    public String getKeywords(){return this.keywords;}
    public void setKeywords(String keywords){this.keywords = keywords;}

    public String getPaperType(){return this.paperType;}
    public void setPaperType(String paperType){this.paperType = paperType;}

    public String getAbstract(){return this._abstract;}
    public void setAbstract(String _abstract){this._abstract= _abstract;}

    public String getAuthor(){return this.author;}
    public void setAuthor(String author){this.author = author;}
}
