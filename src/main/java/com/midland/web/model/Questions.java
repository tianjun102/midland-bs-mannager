package com.midland.web.model;

import java.util.Date;

public class Questions {
    private Integer id;

    private String questionsTitle;

    private Integer source;

    private Date questionTime;

    private String questionName;

    private String questionPhone;

    private String auditor;

    private Integer status;

    private Integer clickNum;

    private Integer fabulous;

    private String questionsArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionsTitle() {
        return questionsTitle;
    }

    public void setQuestionsTitle(String questionsTitle) {
        this.questionsTitle = questionsTitle == null ? null : questionsTitle.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    public String getQuestionPhone() {
        return questionPhone;
    }

    public void setQuestionPhone(String questionPhone) {
        this.questionPhone = questionPhone == null ? null : questionPhone.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getFabulous() {
        return fabulous;
    }

    public void setFabulous(Integer fabulous) {
        this.fabulous = fabulous;
    }

    public String getQuestionsArea() {
        return questionsArea;
    }

    public void setQuestionsArea(String questionsArea) {
        this.questionsArea = questionsArea == null ? null : questionsArea.trim();
    }
}