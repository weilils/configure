package com.o2o.utool;

public class PathUtil {
	public static String getImgRootPath()
	{
		String basePath;
		String Seperater=System.getProperty("file.separator");
		if(System.getProperty("os.name").contains("Windows"))
		{
			basePath="D:/o2oImg/";
		}
		else
		{
			basePath="/home/li/o2oImg/";
		}
		basePath.replace("/", Seperater);
		return basePath;
		
	}
	public static String getShopImgRootPath(Long Shopid)
	{
		String ImgPath="Upload/shop/"+Shopid+"/shopimg/";
		String Seperater=System.getProperty("file.separator");
		ImgPath.replace("/", Seperater);
		return ImgPath;
		
	}
	public static void main(String args[])
	{
		
		System.out.println(getImgRootPath()+getShopImgRootPath(2L));
	}
}
