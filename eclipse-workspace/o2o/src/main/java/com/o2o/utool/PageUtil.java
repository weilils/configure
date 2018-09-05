package com.o2o.utool;

public class PageUtil {
	public static int CoverpageToIndex(int pagenum,int pagesize)
	{
		return (pagenum>0)?(pagenum-1)*pagesize:0;
	}

}
