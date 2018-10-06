package com.example.allpome.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class UserInfo {
    
    //@Id//主键
    //@GeneratedValue//自增长
    private String UserID;//id
    //@Column(length = 255)//长度30
    private String PassWord;//名称
    //@Column(nullable = false)//不可空
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