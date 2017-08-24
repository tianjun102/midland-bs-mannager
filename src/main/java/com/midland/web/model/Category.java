package com.midland.web.model;


public class Category{
	/**
	 * 
	 **/
	private Integer id;
	/**
	 * 分类名称
	 **/
	private String cateName;
	/**
	 * 0=开放；1=关闭
	 **/
	private Integer status;
	/**
	 * 排序值
	 **/
	private Integer orderBy;
	/**
	 * 父节点id
	 **/
	private Integer parentId;
	/**
	 * 0=市场调研分类；1=资讯分类
	 **/
	private Integer type;
	/**
	 * 0未删除，1删除
	 **/
	private Integer isDelete;
	/**
	 * 城市名称
	 **/
	private String cityName;
	/**
	 * 城市ID
	 **/
	private String cityId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("Category{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (cateName != null) {
			sb.append(", \"cateName\":\"").append(cateName).append("\"");
		}
		if (status != null) {
			sb.append(", \"status\":\"").append(status).append("\"");
		}
		if (orderBy != null) {
			sb.append(", \"orderBy\":\"").append(orderBy).append("\"");
		}
		if (parentId != null) {
			sb.append(", \"parentId\":\"").append(parentId).append("\"");
		}
		if (type != null) {
			sb.append(", \"type\":\"").append(type).append("\"");
		}
		if (isDelete != null) {
			sb.append(", \"isDelete\":\"").append(isDelete).append("\"");
		}
		if (cityId != null) {
			sb.append(", \"cityId\":\"").append(cityId).append("\"");
		}
		if (cityName != null) {
			sb.append(", \"cityName\":\"").append(cityName).append("\"");
		}
		return sb.toString();
	}
}