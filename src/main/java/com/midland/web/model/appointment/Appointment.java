package com.midland.web.model.appointment;

public class Appointment {
    private Integer id;
    /**
     * 委托编号
     */
    private String appointSn;
    /**
     * 信息来源，0=网站；1=微站
     */
    private Integer source;
    /**
     * 称呼
     */
    private String call;
    /**
     * 电话
     */
    private String phone;
    /**
     * 类型 0住宅，1公寓，2写字楼，3商铺
     */
    private Integer houseType;
    /**
     * 分类 0 出售，1出租
     */
    private Integer sellRent;
    /**
     * 委托时间
     */
    private String appointmentTime;
    /**
     * 所属区域
     */
    private String area;
    /**
     * 小区名
     */
    private String communityName;
    /**
     * 门牌地址
     */
    private String address;
    /**
     * 户型
     */
    private String layout;
    /**
     * 面积
     */
    private String measure;
    /**
     * 价格
     */
    private String price;
    /**
     * 装修类型，0简装，1精装，2豪华
     */
    private String decoration;
    /**
     * 预约时间
     */
    private String entrustTime;
    /**
     * 经纪人id
     */
    private Integer userId;
    /**
     * 经纪人
     */
    private String userCnName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 处理时间
     */
    private String handleTime;
    
    /**
     *
     */
    
    private transient String startTime;
    
    /**
     *
     */
    private transient String endTime;
    
    /**
     * 备注
     */
    private String remark;
    
    
    public String getDecoration() {
        return decoration;
    }
    
    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppointSn() {
        return appointSn;
    }

    public void setAppointSn(String appointSn) {
        this.appointSn = appointSn == null ? null : appointSn.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call == null ? null : call.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
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

    public String getEntrustTime() {
        return entrustTime;
    }

    public void setEntrustTime(String entrustTime) {
        this.entrustTime = entrustTime;
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

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}