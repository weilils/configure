package com.o2o.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.o2o.dao.ShopCataDao;
import com.o2o.entity.Shop_catagray;
import com.o2o.service.Shop_catagroyService;

@Service
public class ShopCatagroyServiceImpl implements Shop_catagroyService {
	@Autowired
	private ShopCataDao shopCataDao;

	@Override
	public List<Shop_catagray> getShopCatagroy(Shop_catagray shop_catagroy) {
		// TODO Auto-generated method stub
		List<Shop_catagray>map=shopCataDao.getShopCatagroy(shop_catagroy);
		return map;
	}

}
