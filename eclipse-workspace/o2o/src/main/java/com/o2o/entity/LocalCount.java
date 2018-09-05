package com.o2o.entity;

import java.util.Date;

public class LocalCount {
	private Long id;
	private String localCount;
	private String password;
	private Date create_time;
	private Date modify_time;
	private personinf pf;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocalCount() {
		return localCount;
	}
	public void setLocalCount(String localCount) {
		this.localCount = localCount;
	}
	public String getPasseord() {
		return password;
	}
	public void setPasseord(String passeord) {
		this.password = passeord;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public personinf getPf() {
		return pf;
	}
	public void setPf(personinf pf) {
		this.pf = pf;
	}
}
