package com.example.edp20;

public class DataClass {

    private String dataTitle;
    private int dataDesc;
    private String dataLang;
    private int dataImage;
    private int dataTime;


    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataLang() {
        return dataLang;
    }

    public int getDataImage() {
        return dataImage;
    }

    public int getDataTime() {
        return dataTime;
    }

    public void setDataTime(int dataTime) {
        this.dataTime = dataTime;
    }

    public DataClass(String dataTitle, int dataDesc, String dataLang, int dataImage, int dataTime) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
        this.dataTime = dataTime;
    }

}

