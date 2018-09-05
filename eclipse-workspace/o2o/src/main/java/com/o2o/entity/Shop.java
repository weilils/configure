package com.o2o.entity;

import java.util.Date;

public class Shop
{
	private Long id;
	private String name;
	private String description;
	private personinf onwer;
	private Integer priority;
	private String imag;
	private String contact_inf;
	private String address;
	private Area area;
	private Integer enable_status;
	private Shop_catagray catagray;
	private String advice;
	private Date createtime;
	private Date last_modifytime;
	public Long getId() {
		return id;
	}
	public Integer getEnable_status() {
		return enable_status;
	}
	public void setEnable_status(Integer enable_status) {
		this.enable_status = enable_status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public personinf getOnwer() {
		return onwer;
	}
	public void setOnwer(personinf onwer) {
		this.onwer = onwer;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getImag() {
		return imag;
	}
	public void setImag(String imag) {
		this.imag = imag;
	}
	public String getContact_inf() {
		return contact_inf;
	}
	public void setContact_inf(String contact_inf) {
		this.contact_inf = contact_inf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Shop_catagray getCatagray() {
		return catagray;
	}
	public void setCatagray(Shop_catagray catagray) {
		this.catagray = catagray;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLast_modifytime() {
		return last_modifytime;
	}
	public void setLast_modifytime(Date last_modifytime) {
		this.last_modifytime = last_modifytime;
	}
}