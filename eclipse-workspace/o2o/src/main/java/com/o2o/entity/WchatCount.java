package com.o2o.entity;

import java.util.Date;

public class WchatCount {
	private Long id;
	private String commonId;
	private Date create_time;
	private personinf inf;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommonId() {
		return commonId;
	}
	public void setCommonId(String commonId) {
		this.commonId = commonId;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public personinf getInf() {
		return inf;
	}
	public void setInf(personinf inf) {
		this.inf = inf;
	}
	

}
