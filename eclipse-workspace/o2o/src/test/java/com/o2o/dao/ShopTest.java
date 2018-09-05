package com.o2o.dao;

import com.o2o.entity.*;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	public void test3()
	{
		Area area=new Area();
		area.setId(1);
		Shop shop=new Shop();
		shop.setArea(area);
		List<Shop>shop_list=shopDao.getShopList(shop,0, 2);
		List<Shop>shop_list1=shopDao.getShopList(shop,0,100);
		int num=shopDao.getSelectSize(shop);
		System.out.print(shop_list.size());
		assertEquals(num,shop_list1.size());
		
		
	}
	
	@Test
	@Ignore
	public void test2() {
		
		Shop shop=shopDao.getShopInfo(1L);
		System.out.println("shop_inf.name:"+shop.getName());
		System.out.println("shop_inf.areaName:"+shop.getArea().getName());
	}

	@Test
	@Ignore // 忽略此次测试
	public void test() {
		Shop shop = new Shop();
		Shop_catagray catagray = new Shop_catagray();
//		personinf inf=new personinf();
//		Area area=new Area();
		catagray.setId(1L);
//		inf.setId(1L);
//		area.setId(1);/*储存在数据库中的shop表中只包含对应的id,所以测试时只用设置id*/
//		shop.setArea(area);
//		shop.setOnwer(inf);
		shop.setCatagray(catagray);
//		shop.setName("铁串功锦州烧烤");
//		shop.setDescription("烤鸭大虾 鲍鱼饭 巧克力慕斯 现榨果汁 应有尽有!");
//		shop.setAddress("test");
//		shop.setContact_inf("15208315641");/*设置店铺中信息不为空的部分*/
//		System.out.println(shopDao.addShop(shop));
		shop.setId(1L);
		shop.setLast_modifytime(new Date());
		shop.setAddress("新的测试数据");
		assertEquals(1, shopDao.updateShop(shop));
	}

}
