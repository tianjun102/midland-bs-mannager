package com.midland.web.model;


public class Menu{
	/**
	 * 菜单表主键
	 **/
	private Integer id;
	/**
	 * 小图标
	 **/
	private String iconImg;
	/**
	 * 城市id
	 **/
	private Integer cityId;
	/**
	 * 城市名称
	 **/
	private String city;
	
	/**
	 * 0=pc网站；1=微站
	 **/
	private Integer platform;
	/**
	 * 菜单名称
	 **/
	private String menuName;
	/**
	 * 点击量
	 **/
	private Integer clickNum;
	/**
	 * 排序字段
	 **/
	private Integer orderby;
	/**
	 * 菜单栏链接
	 **/
	private String url;
	/**
	 * 是否开启
	 **/
	private Integer isshow;
	/**
	 * position=1顶部；position=0底部
	 **/
	private Integer position;
	/**
	 * 父节点id
	 **/
	private Integer parentId;
	/**
	 * 平台来源 0=网站；1=微站
	 **/
	private Integer source;
	
	
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIconImg() {
		return iconImg;
	}

	public void setIconImg(String iconImg) {
		this.iconImg = iconImg;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("Menu{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (iconImg != null) {
			sb.append(", \"iconImg\":\"").append(iconImg).append("\"");
		}
		if (cityId != null) {
			sb.append(", \"cityId\":\"").append(cityId).append("\"");
		}
		if (platform != null) {
			sb.append(", \"platform\":\"").append(platform).append("\"");
		}
		if (menuName != null) {
			sb.append(", \"menuName\":\"").append(menuName).append("\"");
		}
		if (clickNum != null) {
			sb.append(", \"clickNum\":\"").append(clickNum).append("\"");
		}
		if (orderby != null) {
			sb.append(", \"orderby\":\"").append(orderby).append("\"");
		}
		if (url != null) {
			sb.append(", \"url\":\"").append(url).append("\"");
		}
		if (isshow != null) {
			sb.append(", \"isshow\":\"").append(isshow).append("\"");
		}
		if (position != null) {
			sb.append(", \"position\":\"").append(position).append("\"");
		}
		if (parentId != null) {
			sb.append(", \"parentId\":\"").append(parentId).append("\"");
		}
		if (source != null) {
			sb.append(", \"source\":\"").append(source).append("\"");
		}
		return sb.toString();
	}
}