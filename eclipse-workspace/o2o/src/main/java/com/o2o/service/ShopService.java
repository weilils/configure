package com.o2o.service;
import java.io.InputStream;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
public interface ShopService {
	/*Service的接口，返回ShopExecution,
	 * 以便判断是否执行成功，
	 * 或者继续进行其他操作
	 */
	ShopExecution getShopList(Shop shop,int pageNum,int pageSize);//根据页数，以及size返回shop的信息
	ShopExecution addShop(Shop shop,InputStream img,String filename);
	ShopExecution mdifyShop(Shop shop,InputStream img,String filename);
	Shop  getShopInf(Long Id);
}

