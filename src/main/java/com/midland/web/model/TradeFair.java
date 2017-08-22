package com.midland.web.model;


public class TradeFair{
	/**
	 * 楼盘展销会主键id
	 **/
	private Integer id;
	/**
	 * 楼盘图片连接
	 **/
	private String imgUrl;
	/**
	 * 标题
	 **/
	private String title;
	/**
	 * 楼盘id
	 **/
	private Integer housesId;
	/**
	 * 简介
	 **/
	private String introduction;
	/**
	 * 是否开启
	 **/
	private Integer isShow;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHousesId() {
		return housesId;
	}

	public void setHousesId(Integer housesId) {
		this.housesId = housesId;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("TradeFair{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (imgUrl != null) {
			sb.append(", \"imgUrl\":\"").append(imgUrl).append("\"");
		}
		if (title != null) {
			sb.append(", \"title\":\"").append(title).append("\"");
		}
		if (housesId != null) {
			sb.append(", \"housesId\":\"").append(housesId).append("\"");
		}
		if (introduction != null) {
			sb.append(", \"introduction\":\"").append(introduction).append("\"");
		}
		if (isShow != null) {
			sb.append(", \"isShow\":\"").append(isShow).append("\"");
		}
		if (isDelete != null) {
			sb.append(", \"isDelete\":\"").append(isDelete).append("\"");
		}
		return sb.toString();
	}
}