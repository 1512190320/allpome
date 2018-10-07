package com.example.allpome.entity;

public class AutherInfo {

    private String AutherID;
    private  String AutherName;
    private  String AurherIntroduce;

    public AutherInfo() {
    }

    public AutherInfo(String autherID, String autherName, String aurherIntroduce) {
        AutherID = autherID;
        AutherName = autherName;
        AurherIntroduce = aurherIntroduce;
    }

    public String getAutherID() {
        return AutherID;
    }

    public void setAutherID(String autherID) {
        AutherID = autherID;
    }

    public String getAutherName() {
        return AutherName;
    }

    public void setAutherName(String autherName) {
        AutherName = autherName;
    }

    public String getAurherIntroduce() {
        return AurherIntroduce;
    }

    public void setAurherIntroduce(String aurherIntroduce) {
        AurherIntroduce = aurherIntroduce;
    }
}
