package com.o2o.service;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.o2o.dao.test;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.Shop;
import com.o2o.entity.Shop_catagray;
import com.o2o.entity.personinf;
import com.o2o.enumes.ShopEnume;
import com.o2o.service.impl.AreaServiceImpl;

public class SreviceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Autowired
	private ShopService shopService;

	@Test
	public void Test() {
		Shop shop=new Shop();
		Shop_catagray catagray=new Shop_catagray();
		catagray.setId(1L);
		shop.setCatagray(catagray);
		ShopExecution execution;
		execution=shopService.getShopList(shop, 2,5);//页数从1开始
		System.out.println("店铺数目:"+execution.getShopList().size());
		System.out.println("店鋪总数:"+execution.getShopNum());

	}

	@Test
	@Ignore
	public void test2() throws FileNotFoundException {

		Shop shop = shopService.getShopInf(22L);
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		File file = new File(basePath + "/13.PNG");// java 根据绝对路径创建文件
		ShopExecution execution = shopService.mdifyShop(shop, new FileInputStream(file), file.getName());
		assertEquals(ShopEnume.CHECK.getStatus(), execution.getResultStatus());
	}

	@Test
	@Ignore
	public void test() throws FileNotFoundException {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		// assertEquals("西华大学德馨苑",areaService.getArea().get(0).getName());
		Shop shop = new Shop();
		shop.setName("Unittest");// 注意mybaits会自动返回id到实体类中
		shop.setAddress("UnitTest");
		personinf personInf = new personinf();
		personInf.setId(1L);
		Area area = new Area();
		area.setId(3);
		Shop_catagray catagray = new Shop_catagray();
		catagray.setId(1L);
		shop.setOnwer(personInf);
		shop.setCatagray(catagray);
		shop.setArea(area);
		shop.setContact_inf("1520812456");
		shop.setDescription("测试重构");
		File temp = new File(basePath + "/front.png");
		ShopExecution execution = shopService.addShop(shop, new FileInputStream(temp), temp.getName());
		assertEquals(ShopEnume.CHECK.getStatus(), execution.getResultStatus());
	}
}
