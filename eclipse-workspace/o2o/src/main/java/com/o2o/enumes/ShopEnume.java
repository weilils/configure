package com.o2o.enumes;

public enum ShopEnume {
	CHECK(0, "审查中"), OFFLINE(-1, "以下线"), SUCCESS(1, "操作成功"), PASS(2, "审查通过"), INNERERROR(14001, "内部服务器错误"),
	SHOPIDNOTFOUND(-200, "店铺id不存在"),SHOPNOTEXIT(-120,"店鋪信息为空");
	private int Status;
	private String StatusInf;

	private ShopEnume(int Status,String StatusInf) 
	{
		this.Status=Status;
		this.StatusInf=StatusInf;
	}
	/*通过状态id来获取状态信息*/
	public ShopEnume SearchByStatus(int status)
	{
		for(ShopEnume shopEnume:values())
		{
			if(shopEnume.getStatus()==status)
				return shopEnume;
		}
		return null;
	}
	public int getStatus() {
		return Status;
	}
	public String getStatusInf() {
		return StatusInf;
	}
}
