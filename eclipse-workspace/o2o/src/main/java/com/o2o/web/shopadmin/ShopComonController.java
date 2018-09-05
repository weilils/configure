package com.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/shop")
public class ShopComonController {

	@RequestMapping(value = "/shopOpreation", method = RequestMethod.GET)
	public 	String Shopadd() {

		return "shop/ShopOpreation";
	}
	@RequestMapping(value = "/ShopList", method = RequestMethod.GET)
	public String ShopList() {
		return "shop/ShopList";
	}
	@RequestMapping(value = "/ShManager", method = RequestMethod.GET)
	public String ShopManager() {
		return "shop/ShopManager";
	}
}
