package com.example.allpome.entity;


import java.util.Date;

public class PoemInfo {

    private String PoemID;
    private String PoemTitle;
    private String PoemContent;
    private Integer PoemLike;
    private Integer PoemStar;
    private Integer PoemCommentNum;
    private Integer isOri;

    private String PoemNote;
    private String PoemTranslation;
    private String PoemHoliday;
    private String PoemSolarTerms;
    private String PoemStatement;
    private String PoemSeason;

    private String Author_ID;
    private String UserID;
    private Date WritingDate;
    private Date EditDate;

    private Integer isVisible;

    public PoemInfo() {
    }

    public String getPoemID() {
        return PoemID;
    }

    public void setPoemID(String poemID) {
        PoemID = poemID;
    }

    public String getPoemTitle() {
        return PoemTitle;
    }

    public void setPoemTitle(String poemTitle) {
        PoemTitle = poemTitle;
    }

    public String getPoemContent() {
        return PoemContent;
    }

    public void setPoemContent(String poemContent) {
        PoemContent = poemContent;
    }

    public Integer getPoemLike() {
        return PoemLike;
    }

    public void setPoemLike(Integer poemLike) {
        PoemLike = poemLike;
    }

    public Integer getPoemStar() {
        return PoemStar;
    }

    public void setPoemStar(Integer poemStar) {
        PoemStar = poemStar;
    }

    public Integer getPoemCommentNum() {
        return PoemCommentNum;
    }

    public void setPoemCommentNum(Integer poemCommentNum) {
        PoemCommentNum = poemCommentNum;
    }

    public Integer isOri() {
        return isOri;
    }

    public void setOri(Integer ori) {
        isOri = ori;
    }

    public String getPoemNote() {
        return PoemNote;
    }

    public void setPoemNote(String poemNote) {
        PoemNote = poemNote;
    }

    public String getPoemTranslation() {
        return PoemTranslation;
    }

    public void setPoemTranslation(String poemTranslation) {
        PoemTranslation = poemTranslation;
    }

    public String getPoemoliday() {
        return PoemHoliday;
    }

    public void setPoemHoliday(String poemHoliday) {
        PoemHoliday = poemHoliday;
    }

    public String getPoemSolarTerms() {
        return PoemSolarTerms;
    }

    public void setPoemSolarTerms(String poemSolarTerms) {
        PoemSolarTerms = poemSolarTerms;
    }

    public String getPoemStatement() {
        return PoemStatement;
    }

    public void setPoemStatement(String poemStatement) {
        PoemStatement = poemStatement;
    }

    public String getPoemSeason() {
        return PoemSeason;
    }

    public void setPoemSeason(String poemSeason) {
        PoemSeason = poemSeason;
    }

    public String getAuthor_ID() {
        return Author_ID;
    }

    public void setAuthor_ID(String author_ID) {
        Author_ID = author_ID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Date getWritingDate() {
        return WritingDate;
    }

    public void setWritingDate(Date writingDate) {
        WritingDate = writingDate;
    }

    public Date getEditDate() {
        return EditDate;
    }

    public void setEditDate(Date editDate) {
        EditDate = editDate;
    }

    public Integer isVisible() {
        return isVisible;
    }

    public void setVisible(Integer visible) {
        isVisible = visible;
    }






}
