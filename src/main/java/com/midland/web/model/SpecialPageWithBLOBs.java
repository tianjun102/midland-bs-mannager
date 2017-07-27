package com.midland.web.model;

public class SpecialPageWithBLOBs extends SpecialPage {
    private String description;

    private String detail;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}