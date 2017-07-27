package com.midland.web.model;

import java.util.Date;

public class Entrust {
    private Integer id;

    private String entrustSn;

    private Integer source;

    private Integer houseType;

    private Integer sellRent;

    private Date entrustTime;

    private String area;

    private String communityName;

    private String address;

    private String layout;

    private String measure;

    private String price;

    private Integer userId;

    private String userCnName;

    private Integer status;

    private Date handleTime;

    private String call;

    private Integer renovation;

    private String supporting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntrustSn() {
        return entrustSn;
    }

    public void setEntrustSn(String entrustSn) {
        this.entrustSn = entrustSn == null ? null : entrustSn.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getSellRent() {
        return sellRent;
    }

    public void setSellRent(Integer sellRent) {
        this.sellRent = sellRent;
    }

    public Date getEntrustTime() {
        return entrustTime;
    }

    public void setEntrustTime(Date entrustTime) {
        this.entrustTime = entrustTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCnName() {
        return userCnName;
    }

    public void setUserCnName(String userCnName) {
        this.userCnName = userCnName == null ? null : userCnName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call == null ? null : call.trim();
    }

    public Integer getRenovation() {
        return renovation;
    }

    public void setRenovation(Integer renovation) {
        this.renovation = renovation;
    }

    public String getSupporting() {
        return supporting;
    }

    public void setSupporting(String supporting) {
        this.supporting = supporting == null ? null : supporting.trim();
    }
}