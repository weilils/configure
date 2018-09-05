package com.o2o.web.superadmin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	org.slf4j.Logger logger=LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	@RequestMapping(value="/listarea",method=RequestMethod.GET)//请求类型为get
	
	private @ResponseBody Map<String, Object>listArea()
	{
		logger.info("-----start---");
		 Map<String, Object>modeMap=new HashMap<>();
		List<Area>arealist=areaService.getArea();
		try
		{
				modeMap.put("row", arealist);
				modeMap.put("total", arealist.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//打印出错误的堆栈信息
			modeMap.put("success", false);
			modeMap.put("errMsg", e.toString());
		}
		logger.info("---fiished----");//测试打印日志信息(级别为info)
		return modeMap;
	}

}
