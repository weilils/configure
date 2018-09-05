package com.o2o.entity;
import java.util.ArrayList;
import java.util.Date;

public class Product {
	private Long id;
	private  Product_catagroy catagroyid;
	private Shop shopid;
	private  String name;
	private String description;
	private String scalimg;
	private ArrayList<ProductImg> img;
	private Integer priority;
	private Float  orginalprice;
	private Float discountprice;
	private  Integer enablestuts;//0表示已下架,1表示正在销售中
	private Date createtime;
	private Date last_modify_time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product_catagroy getCatagroyid() {
		return catagroyid;
	}
	public void setCatagroyid(Product_catagroy catagroyid) {
		this.catagroyid = catagroyid;
	}
	public Shop getShopid() {
		return shopid;
	}
	public void setShopid(Shop shopid) {
		this.shopid = shopid;
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

	public String getScalimg() {
		return scalimg;
	}
	public void setScalimg(String scalimg) {
		this.scalimg = scalimg;
	}
	public ArrayList<ProductImg> getImg() {
		return img;
	}
	public void setImg(ArrayList<ProductImg> img) {
		this.img = img;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Float getOrginalprice() {
		return orginalprice;
	}
	public void setOrginalprice(Float orginalprice) {
		this.orginalprice = orginalprice;
	}
	public Float getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	public Integer getEnablestuts() {
		return enablestuts;
	}
	public void setEnablestuts(Integer enablestuts) {
		this.enablestuts = enablestuts;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLast_modify_time() {
		return last_modify_time;
	}
	public void setLast_modify_time(Date last_modify_time) {
		this.last_modify_time = last_modify_time;
	}
	
}
