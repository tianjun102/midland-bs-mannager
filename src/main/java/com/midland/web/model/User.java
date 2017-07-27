package com.midland.web.model;

import java.util.Date;
import java.util.List;

/**
 * 用户模型
 * 
 * @author 
 * @since 2016年7月5日 下午12:07:20
 **/
public class User {
	/**
	 * 用户id
	 */
    private Integer id;
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户名称
	 */
	private String userCnName;
	/**
	 * 密码
	 */
    private String password;
	/**
	 * etyn 用户类型，：0=智者汇；1=渠道渠道商；2=终端服务商；3=安装专员
	 */
	private Integer userType;
	/**
	 * 状态（0失效，1生效，3删除）
	 */
    private String state;

    private String createTime;
    
    private String modifyTime;
	
	
	private Integer source;
	
	private Integer realRegistrationStatus;
	
	private Integer auditStatus;
	
	private Date auditTime;
	
	private String isBlack;
	
	private String blackRemark;
	/**
	 * 身份证照片
	 */
	private String identification;
	/**
	 * 身份证照片url
	 */
	private String idcartImg;
	/**
	 * 身份证照片url
	 */
	private String idcartImg1;
	/**
	 * 审核人
	 */
	private String auditName;
	/**
	 *
	 */
	private String userRoles;
    
    private String phone;
    
    private String email;
    
    private List<Role> roles;
    
    private String flag;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password,String flag) {
        this.username = username;
        this.password = password;
        this.flag = flag;
    }
	
	public String getIdcartImg1() {
		return idcartImg1;
	}
	
	public void setIdcartImg1(String idcartImg1) {
		this.idcartImg1 = idcartImg1;
	}
	
	public String getAuditName() {
		return auditName;
	}
	
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	
	public Integer getSource() {
		return source;
	}
	
	public void setSource(Integer source) {
		this.source = source;
	}
	
	public Integer getRealRegistrationStatus() {
		return realRegistrationStatus;
	}
	
	public void setRealRegistrationStatus(Integer realRegistrationStatus) {
		this.realRegistrationStatus = realRegistrationStatus;
	}
	
	public Integer getAuditStatus() {
		return auditStatus;
	}
	
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	
	public Date getAuditTime() {
		return auditTime;
	}
	
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	
	public String getIsBlack() {
		return isBlack;
	}
	
	public void setIsBlack(String isBlack) {
		this.isBlack = isBlack;
	}
	
	public String getBlackRemark() {
		return blackRemark;
	}
	
	public void setBlackRemark(String blackRemark) {
		this.blackRemark = blackRemark;
	}
	
	public String getIdentification() {
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getIdcartImg() {
		return idcartImg;
	}
	
	public void setIdcartImg(String idcartImg) {
		this.idcartImg = idcartImg;
	}
	
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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserCnName() {
		return userCnName;
	}

	public void setUserCnName(String userCnName) {
		this.userCnName = userCnName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("id=").append(id);
		sb.append(", username='").append(username).append('\'');
		sb.append(", userCnName='").append(userCnName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", userType=").append(userType);
		sb.append(", state='").append(state).append('\'');
		sb.append(", createTime='").append(createTime).append('\'');
		sb.append(", modifyTime='").append(modifyTime).append('\'');
		sb.append(", source=").append(source);
		sb.append(", realRegistrationStatus=").append(realRegistrationStatus);
		sb.append(", auditStatus=").append(auditStatus);
		sb.append(", auditTime=").append(auditTime);
		sb.append(", isBlack='").append(isBlack).append('\'');
		sb.append(", blackRemark='").append(blackRemark).append('\'');
		sb.append(", identification='").append(identification).append('\'');
		sb.append(", idcartImg='").append(idcartImg).append('\'');
		sb.append(", idcartImg1='").append(idcartImg1).append('\'');
		sb.append(", auditName='").append(auditName).append('\'');
		sb.append(", userRoles='").append(userRoles).append('\'');
		sb.append(", phone='").append(phone).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", roles=").append(roles);
		sb.append(", flag='").append(flag).append('\'');
		sb.append('}');
		return sb.toString();
	}
}