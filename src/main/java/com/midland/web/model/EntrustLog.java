package com.midland.web.model;

public class EntrustLog {
    private Integer entrustLogId;

    private String logTime;

    private Integer operatorid;

    private String operatorName;

    private String remark;

    private Integer state;

    private Integer entrustId;
    
    
    
    public Integer getEntrustLogId() {
        return entrustLogId;
    }

    public void setEntrustLogId(Integer entrustLogId) {
        this.entrustLogId = entrustLogId;
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

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
}