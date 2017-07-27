package com.midland.web.model;

import java.util.Date;

public class Answer {
    private Integer id;

    private Date answerTime;

    private String anwerName;

    private Integer againstnum;

    private Integer supportnum;

    private Integer questionsId;

    private String answerArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnwerName() {
        return anwerName;
    }

    public void setAnwerName(String anwerName) {
        this.anwerName = anwerName == null ? null : anwerName.trim();
    }

    public Integer getAgainstnum() {
        return againstnum;
    }

    public void setAgainstnum(Integer againstnum) {
        this.againstnum = againstnum;
    }

    public Integer getSupportnum() {
        return supportnum;
    }

    public void setSupportnum(Integer supportnum) {
        this.supportnum = supportnum;
    }

    public Integer getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Integer questionsId) {
        this.questionsId = questionsId;
    }

    public String getAnswerArea() {
        return answerArea;
    }

    public void setAnswerArea(String answerArea) {
        this.answerArea = answerArea == null ? null : answerArea.trim();
    }
}