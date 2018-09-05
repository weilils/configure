package com.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.o2o.entity.Area;

public class AreaTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;
	@Test
	public void test()
	{
		List<Area>arealist=areaDao.search();
		System.out.println(arealist.size());
		assertEquals(2,arealist.size());
	}

}
