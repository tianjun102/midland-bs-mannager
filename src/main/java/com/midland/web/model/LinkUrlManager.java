package com.midland.web.model;


public class LinkUrlManager{
	/**
	 * 链接关联表
	 **/
	private Integer id;
	/**
	 * 城市id
	 **/
	private Integer cityId;
	/**
	 * 链接名
	 **/
	private String linkName;
	/**
	 * 链接
	 **/
	private String linkUrl;
	/**
	 * 联系人
	 **/
	private String contacts;
	/**
	 * 联系方式
	 **/
	private String phone;
	/**
	 * 备注
	 **/
	private String remarks;
	/**
	 * 是否开启 0=开启；1=关闭
	 **/
	private Integer isshow;
	/**
	 * 排序字段
	 **/
	private Integer orderby;
	
	private Integer isDelete;


	public Integer getIsDelete() {
		return isDelete;
	}
	
	public void setIsDelete(Integer delete) {
		isDelete = delete;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("LinkUrlManager{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (cityId != null) {
			sb.append(", \"cityId\":\"").append(cityId).append("\"");
		}
		if (linkName != null) {
			sb.append(", \"linkName\":\"").append(linkName).append("\"");
		}
		if (linkUrl != null) {
			sb.append(", \"linkUrl\":\"").append(linkUrl).append("\"");
		}
		if (contacts != null) {
			sb.append(", \"contacts\":\"").append(contacts).append("\"");
		}
		if (phone != null) {
			sb.append(", \"phone\":\"").append(phone).append("\"");
		}
		if (remarks != null) {
			sb.append(", \"remarks\":\"").append(remarks).append("\"");
		}
		if (isshow != null) {
			sb.append(", \"isshow\":\"").append(isshow).append("\"");
		}
		if (orderby != null) {
			sb.append(", \"orderby\":\"").append(orderby).append("\"");
		}
		return sb.toString();
	}
}