package com.pactera.acesys_android;

import java.io.Serializable;

/**
 * ��Ʒ������
 * 
 * @author Brandon
 * @version 1.0
 * created:��2013-06-06
 */
public enum ProductCategory implements Serializable {

	WESTMEDICINE("xiyao","001"), BIOMEDICINE("zhongyao","002");
	
	private String categoryName;  // ������
	private String categoryNo;
	
	/**
	 * ˽�еĹ��캯��
	 * 
	 * @param category ������
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
