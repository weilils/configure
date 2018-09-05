package com.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.o2o.entity.Shop_catagray;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private Shop_catagroyService shop_catagroyService;
	@Test 
	public void test()
	{
		Shop_catagray test=new Shop_catagray();
		Shop_catagray parent=new Shop_catagray();
		parent.setId(1L);
		test.setParent(parent);
		List<Shop_catagray> map=shop_catagroyService.getShopCatagroy(test);
		assertEquals(2, map.size());
	}

}
