package com.pactera.acesys_android;

import java.io.Serializable;

/**
 * 商品种类类
 * 
 * @author Brandon
 * @version 1.0
 * created:　2013-06-06
 */
public enum ProductCategory implements Serializable {

	WESTMEDICINE("xiyao","001"), BIOMEDICINE("zhongyao","002");
	
	private String categoryName;  // 种类名
	private String categoryNo;
	
	/**
	 * 私有的构造函数
	 * 
	 * @param category 种类名
	 */ 
	private ProductCategory(String category, String number) {
		categoryName = category;
		categoryNo = number;
	}
	
	public String getCategoryNo(){
		return categoryNo;
	}

	public String getCategoryName() {		
		return categoryName;
	}
}
