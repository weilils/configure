package com.o2o.dto;
import java.util.List;
import com.o2o.entity.Shop;
import com.o2o.enumes.ShopEnume;

public class ShopExecution {
	//状态信息
	private  int resultStatus;
	private String resultInfo;//对状态标识的文字解释
	private  Shop shop;
	private List<Shop>shopList;
	//店鋪的數量
	private int ShopNum;
	/*对店铺操作失败后，应产生的信息*/
	public ShopExecution(ShopEnume shopEnume)
	{
		this.resultStatus=shopEnume.getStatus();
		this.resultInfo=shopEnume.getStatusInf();
	}
	/*对店铺操作成功后，应产生的信息(对单个店铺的操作)*/
	public ShopExecution(ShopEnume shopEnume,Shop shop)
	{
		this.resultStatus=shopEnume.getStatus();
		this.resultInfo=shopEnume.getStatusInf();
		this.shop=shop;
	}
	/*对店铺操作失败后，应产生的信息(对多个店铺的操作如查询店铺列表)*/
	public ShopExecution(ShopEnume shopEnume,List<Shop> shopList)
	{
		this.resultStatus=shopEnume.getStatus();
		this.resultInfo=shopEnume.getStatusInf();
		this.shopList=shopList;
	}
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
	public List<Shop> getShopList() {
		return shopList;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	public int getShopNum() {
		return ShopNum;
	}
	public void setShopNum(int shopNum) {
		ShopNum = shopNum;
	}
	public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
