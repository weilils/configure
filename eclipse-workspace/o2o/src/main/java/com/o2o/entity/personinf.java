package com.o2o.entity;

import java.util.Date;

public class personinf {
	private Long Id;
	private String name;
	private String profileImg;
	private String email;
	private String sex;
	private Integer enableStyatus;
	private Integer userType;//1¹Ë¿Í£¬2µê¼Ò£¬3³¬»§
	private Date createTime;
	private Date modifytime;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getEnableStyatus() {
		return enableStyatus;
	}
	public void setEnableStyatus(Integer enableStyatus) {
		this.enableStyatus = enableStyatus;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	
}
