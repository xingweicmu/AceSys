package com.pactera.dao.test;

import java.util.ArrayList;

import com.pactera.bean.Product;
import com.pactera.util.JsonTools;

public class TestJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="";
		Product product1 = new Product();
		product1.setProductID(1);
		product1.setProductName("product1");
		product1.setProductNumber("1");
		
		Product product2 = new Product();
		product2.setProductID(2);
		product2.setProductName("product2");
		product2.setProductNumber("2");
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		msg = JsonTools.createJsonString("products", products);
		
		System.out.println(msg);
	}

}
