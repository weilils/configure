package com.o2o.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.o2o.entity.Shop_catagray;

public interface ShopCataDao {
	/*提供shopcatagroylist给上层应用(主要是次级的目录)*/
	List<Shop_catagray>getShopCatagroy(@Param("shop_catagroy")Shop_catagray shop_catagroy);
}
