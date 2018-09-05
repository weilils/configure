package com.o2o.utool;


import javax.servlet.http.HttpServletRequest;

public class KaptchaUtil {
	public static boolean verifyCode(HttpServletRequest request) {
		// 获取生成的验证码值
		String verifyCodeTrue = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 获取用户传入的验证码
		String verifyCodeUser = HttpRequestUtil.getStringParaMeter("J_kaptcha", request);
		System.out.println(verifyCodeUser);
		System.out.println(verifyCodeTrue);
		if (verifyCodeUser != null && verifyCodeTrue.toUpperCase().equals(verifyCodeUser.toUpperCase()))
			return true;
		else
			return false;
	}
}
