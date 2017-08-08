package com.midland.web.model.appointment;

import java.util.Date;

public class AppointLog {
    private Integer appointLogId;

    private String logTime;

    private Integer operatorid;

    private String operatorName;

    private String remark;

    private Integer state;

    private Integer appointId;
    
    
    
    public Integer getAppointLogId() {
        return appointLogId;
    }

    public void setAppointLogId(Integer appointLogId) {
        this.appointLogId = appointLogId;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAppointId() {
        return appointId;
    }

    public void setAppointId(Integer appointId) {
        this.appointId = appointId;
    }
}