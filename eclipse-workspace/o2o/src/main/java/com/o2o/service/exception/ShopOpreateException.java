package com.o2o.service.exception;
public class ShopOpreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShopOpreateException(String errorMessage) {
		super(errorMessage);
	}//由于事务必须要抛出RuntimeException及其子类才回发生回滚，所以需要继承RuntimeException(以便标识何处发生异常)

}
