package com.o2o.utool;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil {
	public static Integer getIntParaMeter(String key,HttpServletRequest request)
	{
		Integer parameter=null;
		try {
			parameter=Integer.parseInt(request.getParameter(key));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return parameter;
	}
	public static Long getLongParaMeter(String key,HttpServletRequest request)
	{
		Long parameter=null;
		try {
			parameter=Long.parseLong(request.getParameter(key));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return parameter;
	}
	public static String getStringParaMeter(String key,HttpServletRequest request)
	{
		String parameter=null;
		try {
			parameter=request.getParameter(key);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return parameter;
	}
}
