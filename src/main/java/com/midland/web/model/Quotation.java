package com.midland.web.model;

import java.util.Date;

public class Quotation {
    private Integer id;

    private Date dataTime;

    private Integer type;

    private Integer cityId;

    private Integer areaId;

    private Integer sliceId;

    private Integer dealNum;

    private Integer dealAcreage;

    private String price;

    private Integer soldNum;

    private String soldArea;

    private String ringRatio;

    private String updateTime;

    private Integer isNew;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getSliceId() {
        return sliceId;
    }

    public void setSliceId(Integer sliceId) {
        this.sliceId = sliceId;
    }

    public Integer getDealNum() {
        return dealNum;
    }

    public void setDealNum(Integer dealNum) {
        this.dealNum = dealNum;
    }

    public Integer getDealAcreage() {
        return dealAcreage;
    }

    public void setDealAcreage(Integer dealAcreage) {
        this.dealAcreage = dealAcreage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public String getSoldArea() {
        return soldArea;
    }

    public void setSoldArea(String soldArea) {
        this.soldArea = soldArea == null ? null : soldArea.trim();
    }

    public String getRingRatio() {
        return ringRatio;
    }

    public void setRingRatio(String ringRatio) {
        this.ringRatio = ringRatio == null ? null : ringRatio.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
}