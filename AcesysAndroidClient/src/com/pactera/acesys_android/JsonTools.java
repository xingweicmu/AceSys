package com.pactera.acesys_android;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Convert json String to Objects
 * @author David.Wei
 * @version 1.0
 * created: 2013-8-19
 */
public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Product> getProducts(String key, String jsonString){
		ArrayList<Product> products = new ArrayList<Product>();
		try{
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray jsonArray = jsonObject.getJSONArray(key);	
			for(int i=0; i<jsonArray.length(); i++){
				JSONObject productJsonObject = jsonArray.getJSONObject(i);
				Product product = new Product();
				product.setMDLNumber(productJsonObject.getString("MDLNumber"));
				product.setCas(productJsonObject.getString("cas"));
				if(productJsonObject.getString("category").equals("WESTMEDICINE"))
					product.setCategory(ProductCategory.WESTMEDICINE);
				else 
					product.setCategory(ProductCategory.BIOMEDICINE);
				product.setDel_soft(productJsonObject.getString("del_soft").charAt(0));
				product.setFormula(productJsonObject.getString("formula"));
				product.setImageName(productJsonObject.getString("imageName"));
				product.setNormalPrice(productJsonObject.getDouble("normalPrice"));
				product.setNote(productJsonObject.getString("note"));
				product.setProductID(productJsonObject.getInt("productID"));
				product.setProductName(productJsonObject.getString("productName"));
				product.setProductNumber(productJsonObject.getString("productNumber"));
				product.setRealStock(productJsonObject.getInt("realStock"));
				product.setStock(productJsonObject.getInt("stock"));
				product.setVipPrice(productJsonObject.getDouble("vipPrice"));
				product.setWeight(productJsonObject.getDouble("weight"));
				products.add(product);			
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}
}
