package com.midland.web.model;

import java.util.Date;

public class Feedback{
	/**
	 * 反馈信息表
	 **/
	private Integer id;
	/**
	 * 用户昵称
	 **/
	private String username;
	/**
	 * 手机号码
	 **/
	private String phone;
	/**
	 * 
	 **/
	private String feedbackContent;
	/**
	 * 反馈时间
	 **/
	private Date addTime;
	/**
	 * 状态 0=已取消；1=已完成；2=处理中
	 **/
	private Integer status;
	/**
	 * 备注
	 **/
	private String remark;
	/**
	 * 0未删除，1删除
	 **/
	private Integer isDelete;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("Feedback{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (username != null) {
			sb.append(", \"username\":\"").append(username).append("\"");
		}
		if (phone != null) {
			sb.append(", \"phone\":\"").append(phone).append("\"");
		}
		if (feedbackContent != null) {
			sb.append(", \"feedbackContent\":\"").append(feedbackContent).append("\"");
		}
		if (addTime != null) {
			sb.append(", \"addTime\":\"").append(addTime).append("\"");
		}
		if (status != null) {
			sb.append(", \"status\":\"").append(status).append("\"");
		}
		if (remark != null) {
			sb.append(", \"remark\":\"").append(remark).append("\"");
		}
		if (isDelete != null) {
			sb.append(", \"isDelete\":\"").append(isDelete).append("\"");
		}
		return sb.toString();
	}
}