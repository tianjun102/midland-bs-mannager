package com.midland.web.model;

import java.util.Date;

public class LiaisonRecord {
    private Integer id;

    private String name;

    private String phone;

    private String cate;

    private Date addTime;

    private Integer isOntact;

    private String leavingMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate == null ? null : cate.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getIsOntact() {
        return isOntact;
    }

    public void setIsOntact(Integer isOntact) {
        this.isOntact = isOntact;
    }

    public String getLeavingMessage() {
        return leavingMessage;
    }

    public void setLeavingMessage(String leavingMessage) {
        this.leavingMessage = leavingMessage == null ? null : leavingMessage.trim();
    }
}