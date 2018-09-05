package com.o2o.entity;

import java.util.Date;

public class Top {
	private Integer id;
	private Integer priority;//权重
	private String topimg;
	private Integer enablestatus;//0表示不可用，1表示可用
	private String link;
	private Date createtime;
	private Date latmodifytime;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getTopimg() {
		return topimg;
	}
	public void setTopimg(String topimg) {
		this.topimg = topimg;
	}
	public Integer getEnablestatus() {
		return enablestatus;
	}
	public void setEnablestatus(Integer enablestatus) {
		this.enablestatus = enablestatus;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLatmodifytime() {
		return latmodifytime;
	}
	public void setLatmodifytime(Date latmodifytime) {
		this.latmodifytime = latmodifytime;
	}
}
