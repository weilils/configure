package com.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.o2o.entity.Shop_catagray;

public class Shop_catagroyTest extends BaseTest {
	@Autowired
	private ShopCataDao shopCataDao;
	
	@Test
	@Ignore
	public void test()
	{
		List<Shop_catagray>map=shopCataDao.getShopCatagroy(new Shop_catagray());
		assertEquals(2,map.size());
		Shop_catagray test=new Shop_catagray();
		Shop_catagray test_parent=new Shop_catagray();
	    test_parent.setId(1L);;
	    test.setParent(test_parent);//设置查询的父目录
	    List<Shop_catagray>map2=shopCataDao.getShopCatagroy(new Shop_catagray());
		System.out.print(map2.get(0).getName());
	}
}
