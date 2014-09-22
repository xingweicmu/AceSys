package com.pactera.acesys_android;

import java.util.ArrayList;

import android.app.Application;

/**
 * Data sharing
 * @author David.Wei
 * @version 1.0
 * created: 2013-8-19
 */
public class DataTransmit extends Application {

	private ArrayList<?> products;
	
	public void setProducts(ArrayList<?> products) {
		this.products = products;
	}
	
	public ArrayList<?> getProducts(){
		return this.products;
	}
	
	public void onCreate(){
		super.onCreate();		
	}

}
