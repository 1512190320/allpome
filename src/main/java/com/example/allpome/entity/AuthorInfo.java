package com.example.allpome.entity;

public class AuthorInfo {
    private String AuthorID;
    private  String AuthorName;
    private  String AuthorIntroduce;

    public AuthorInfo() {
    }

    public AuthorInfo(String AuthorID, String AuthorName, String authorIntroduce) {
        AuthorID = AuthorID;
        AuthorName = AuthorName;
        AuthorIntroduce = authorIntroduce;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String authorID) {
        AuthorID = authorID;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getAuthorIntroduce() {
        return AuthorIntroduce;
    }

    public void setAuthorIntroduce(String authorIntroduce) {
        AuthorIntroduce = authorIntroduce;
    }
}
