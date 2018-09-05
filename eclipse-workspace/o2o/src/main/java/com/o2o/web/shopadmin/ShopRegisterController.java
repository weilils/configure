package com.o2o.web.shopadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.Shop;
import com.o2o.entity.Shop_catagray;
import com.o2o.entity.personinf;
import com.o2o.enumes.ShopEnume;
import com.o2o.service.AreaService;
import com.o2o.service.ShopService;
import com.o2o.service.Shop_catagroyService;
import com.o2o.utool.HttpRequestUtil;
import com.o2o.utool.KaptchaUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopRegisterController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private Shop_catagroyService shop_catagroy;
	@Autowired
	private AreaService area;

	/*
	 * 根据传入的参数判断是否应该重定向 根据前台传递的shopid来创建shop实体类储存在session中，并将其返回前台 以此来决定是否需要重定向
	 */
	@RequestMapping(value = "/getshopmanagerinf", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShopManagerInf(HttpServletRequest request) {

		Map<String, Object> map = new HashMap<>();
		try {
			long shopid = HttpRequestUtil.getLongParaMeter("shopid", request);
			Shop condition;
			if (shopid > 0) {
				condition = new Shop();
				condition.setId(shopid);
				request.getSession().setAttribute("shopinf", condition);
				map.put("redirect", false);
			} else {
				Object tmp = request.getSession().getAttribute("shopinf");
				if (tmp != null) {
					condition = (Shop) tmp;
					map.put("currentShopId",condition.getId());
					map.put("redirect", false);
				} else {
					map.put("redirect", true);
					map.put("url", "/o2o/getshoplist");
				}
			}
			map.put("success", true);
			return map;
		} catch (Exception e) {
			map.put("success", false);
			map.put("errorMsg", e.getMessage());
			return map;
		}
	}

	/* 获取店铺列表(根据当前的用户) */
	@RequestMapping(value = "/getshoplist", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShopList(HttpServletRequest request) {

		Shop condition = new Shop();
		Map<String, Object> map = new HashMap<>();
		try {
			/* 后面的user信息通过session获取 */
			personinf user = new personinf();
			user.setId(1L);
			user.setName("李四");
			request.getSession().setAttribute("user", user);
			personinf conditions = (personinf) request.getSession().getAttribute("user");
			if (conditions != null) {
				condition.setOnwer(user);
				ShopExecution execution = shopService.getShopList(condition, 0, 200);// 对于个人店主管理店铺时来说不必分页
				if (execution.getResultStatus() != ShopEnume.CHECK.getStatus()) {
					map.put("success", false);
					map.put("errorMsg", execution.getResultInfo());
				} else {
					map.put("shopList", execution.getShopList());
					map.put("username", user.getName());
					map.put("success", true);
				}

			} else {
				map.put("success", false);
				map.put("errorMsg", "参数错误！");
			}
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			map.put("success", false);
			map.put("errorMsg", e.getMessage());
			return map;
		}
	}

	/* 获取店铺列表以及区域列表信息以初始化前台信息 */
	@RequestMapping(value = "/oinitalSouce", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ResponseData() {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			Shop_catagray parent = new Shop_catagray();
			parent.setId(1L);
			Shop_catagray condition = new Shop_catagray();
			condition.setParent(parent);
			List<Shop_catagray> shop_list = shop_catagroy.getShopCatagroy(condition);
			List<Area> areaList = area.getArea();
			resultMap.put("success", true);
			resultMap.put("shopCata_groyList", shop_list);
			resultMap.put("areaList", areaList);
			return resultMap;
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("success", false);
			resultMap.put("errorMsg", e.toString());
			return resultMap;
		}
	}

	@RequestMapping(value = "/getshopinf", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getInfList(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			long id = HttpRequestUtil.getLongParaMeter("shopid", request);
			if (id > -1)// 获取id成功
			{
				Shop shop = shopService.getShopInf(id);
				List<Area> areaList = area.getArea();
				map.put("shop", shop);
				map.put("arealist", areaList);
				map.put("success", true);
			} else {
				map.put("success", false);
				map.put("erroMsg", "获取shopid失败!");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("erroMsg", e.toString());
		}
		return map;
	}

	@RequestMapping(value = "/modifyshop", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyShopInf(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<>();
		try {
			ObjectMapper mapper = new ObjectMapper();// 将json转化为实体对象
			System.out.println(HttpRequestUtil.getStringParaMeter("shopName", req));
			// 验证验证码
			if (KaptchaUtil.verifyCode(req) == false) {
				map.put("success", false);
				map.put("errorMsg", "验证码填写错误！");
				return map;
			}
			Shop shop;
			// 解析req传递过来的参数
			String shopName = HttpRequestUtil.getStringParaMeter("shopName", req);// 获取前台传递的名为ShopName的参数
			try {
				shop = mapper.readValue(shopName, Shop.class);
			} catch (Exception e) {
				// TODO: handle exception
				map.put("success", false);
				map.put("errorMsg", e.toString());
				return map;
			}
			/* 判断是否需要修改图片 */
			CommonsMultipartFile shopImg = null;
			CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getSession().getServletContext());
			if (resolver.isMultipart(req)) {
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
				shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopimg");
			}
			ShopExecution execution = null;
			if (shopImg != null) {
				execution = shopService.mdifyShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
			} else
				execution = shopService.mdifyShop(shop, null, null);
			if (execution.getResultStatus() != ShopEnume.CHECK.getStatus()) {
				map.put("success", false);
				map.put("errorMsg", execution.getResultInfo());
				return map;
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
			map.put("errorMsg", e.getMessage());
		}
		// 返回必要的参数给前台
		return map;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST) // 请求方式为request
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<>();// 创建返回对象
		ObjectMapper mapper = new ObjectMapper();// 将json转化为实体对象
		System.out.println(HttpRequestUtil.getStringParaMeter("shopName", req));
		// 验证验证码
		if (KaptchaUtil.verifyCode(req) == false) {
			map.put("success", false);
			map.put("errorMsg", "验证码填写错误！");
			return map;
		}
		Shop shop;
		// 解析req传递过来的参数
		String shopName = HttpRequestUtil.getStringParaMeter("shopName", req);// 获取前台传递的名为ShopName的参数
		try {
			shop = mapper.readValue(shopName, Shop.class);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("success", false);
			map.put("errorMsg", e.toString());
			return map;
		}
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getSession().getServletContext());
		if (resolver.isMultipart(req)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopimg");
		} else {
			map.put("success", false);
			map.put("errorMsg", "没有上传店铺图片");
			return map;
		}
		/* 之后会从Session中生成user信息 */
		personinf inf = (personinf) req.getSession().getAttribute("user");
		shop.setOnwer(inf);
//		File img=new File(Thread.currentThread().getContextClassLoader().getResource("").getPath()+ImgUtil.RandomFilename()+shopImg.getName());;
//		try {
//			revertCommonsMultipartFile(shopImg.getInputStream(),img);
//		} catch (FileNotFoundException e) {
//			map.put("success", false);
//			map.put("errMsg", "创建临时文件失败！");
//			return map;
//		} catch (IOException e) {
//			map.put("success", false);
//			map.put("errMsg", e.toString());
//			return map;
//		}
		// 注册店铺

		ShopExecution execution = null;
		try {
			execution = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
		} catch (IOException e) {
			map.put("success", false);
			map.put("errorMsg", e.toString());
			return map;

		}
		if (execution.getResultStatus() != ShopEnume.CHECK.getStatus()) {
			map.put("success", false);
			map.put("errorMsg", execution.getResultInfo());
			return map;
		}
		/* 获取可用的店铺列表方便修改操作 */
		@SuppressWarnings("unchecked")
		List<Shop> shopList = (List<Shop>) req.getSession().getAttribute("shoplist");
		if (shopList == null)
			shopList = new ArrayList<>();
		shopList.add(execution.getShop());
		req.getSession().setAttribute("shoplist", shopList);
		map.put("success", true);
		// 返回必要的参数
		return map;
	}
}
/* 不要将InputStream转化为File会产生不必要的文件，会增大系统的不稳定性(多次io操作可能会出错) */
//	public File revertCommonsMultipartFile(InputStream fileInputStream, File file) throws FileNotFoundException {
//		FileOutputStream fileOutputStream = new FileOutputStream(file);
//		byte bytes[] = new byte[1024];
//		int num;
//		try {
//			while ((num = fileInputStream.read(bytes, 0, 1024)) != -1) {
//				fileOutputStream.write(bytes, 0, num);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fileInputStream != null) {
//
//					fileInputStream.close();
//				}
//				if (fileOutputStream != null) {
//					fileOutputStream.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return file;
//	}
//}
