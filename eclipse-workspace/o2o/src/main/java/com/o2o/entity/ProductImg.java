package com.o2o.entity;

import java.util.Date;

public class ProductImg {
	private Long id;
	private Long productid;
	private String procucturl;//可以从商品图片直接进入商品的详情
	private Integer priority;//展示的权重
	private String img;
	private Date creattime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public String getProcucturl() {
		return procucturl;
	}
	public void setProcucturl(String procucturl) {
		this.procucturl = procucturl;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	

}
