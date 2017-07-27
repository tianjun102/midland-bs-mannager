package com.midland.web.model;

public class FooterWithBLOBs extends Footer {
    private String registrationProtocol;

    private String disclaimer;

    private String recordNumber;

    private String recruitment;

    private String aboutUs;

    private String privacy;

    private String serviceArea;

    private String tradingProcess;

    private String purpose;

    private String eliteDesc;

    private String membership;

    private String development;

    public String getRegistrationProtocol() {
        return registrationProtocol;
    }

    public void setRegistrationProtocol(String registrationProtocol) {
        this.registrationProtocol = registrationProtocol == null ? null : registrationProtocol.trim();
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer == null ? null : disclaimer.trim();
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber == null ? null : recordNumber.trim();
    }

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment == null ? null : recruitment.trim();
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs == null ? null : aboutUs.trim();
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy == null ? null : privacy.trim();
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea == null ? null : serviceArea.trim();
    }

    public String getTradingProcess() {
        return tradingProcess;
    }

    public void setTradingProcess(String tradingProcess) {
        this.tradingProcess = tradingProcess == null ? null : tradingProcess.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getEliteDesc() {
        return eliteDesc;
    }

    public void setEliteDesc(String eliteDesc) {
        this.eliteDesc = eliteDesc == null ? null : eliteDesc.trim();
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership == null ? null : membership.trim();
    }

    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development == null ? null : development.trim();
    }
}