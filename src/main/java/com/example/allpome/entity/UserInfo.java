package com.example.allpome.entity;

public class UserInfo {

    private String UserID;//id
    private String PassWord;
    private Integer UserFollow;
    private Integer UserFan;

    public UserInfo()
    {
    }

    public UserInfo(String UserID, String PassWord)
    {
        this.UserID = UserID;
        this.PassWord = PassWord;
    }

    public String getUserID()
    {
        return UserID;
    }

    public void setUserID(String UserID)
    {
        this.UserID = UserID;
    }

    public String getPassWord()
    {
        return PassWord;
    }

    public void setPassWord(String PassWord)
    {
        this.PassWord = PassWord;
    }

    public Integer getUserFollow()
    {
        return UserFollow;
    }

    public void setUserFollow(Integer UserFollow)
    {
        this.UserFollow = UserFollow;
    }

    public Integer getUserFan()
    {
        return UserFan;
    }

    public void setUserFan(Integer UserFan)
    {
        this.UserFan = UserFan;
    }
}