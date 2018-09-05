package com.o2o.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.o2o.entity.Shop;
//对店铺信息进行管理
public interface ShopDao {
	/*按照条件查询店铺信息*/
	List<Shop>getShopList(@Param("ShopCondition")Shop shop,@Param("StartIndex")int startindex,@Param("PageSize")int pagesize);
	/*按照条件查询店铺总数*/
	int getSelectSize(@Param("ShopCondition")Shop shop);
	Shop getShopInfo(Long shopId);//根据shopId查询对应的Shop信息
	int addShop(Shop shop);//返回的是受影响中的行数dao层(实现在mapper中)
	int updateShop(Shop shop);//更新店铺信息
}
