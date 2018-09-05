package com.o2o.entity;

import java.util.Date;

public class Shop_catagray {
	private Long id;
	private String name;
	private String img;
	private Integer priority;
	private String description;
	private Shop_catagray parent;//���parentId==null��õ���Ϊ����Ŀ¼
	private Date create_time;
	private Date last_modifytime;
	public Long getId() {
		return id;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Shop_catagray getParent() {
		return parent;
	}
	public void setParent(Shop_catagray parent) {
		this.parent = parent;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_modifytime() {
		return last_modifytime;
	}
	public void setLast_modifytime(Date last_modifytime) {
		this.last_modifytime = last_modifytime;
	}

}
