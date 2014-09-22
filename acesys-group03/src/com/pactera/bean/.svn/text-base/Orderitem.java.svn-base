/**
 * 存放数据封装类
 */
package com.pactera.bean;

import java.io.Serializable;

/**
 * 订单项表类
 * @author 金轶伦
 * @version 1.0
 * create 2013-06-06
 */
public class Orderitem implements Serializable {
	private int oiid;//订单项ID
	private Orders orders;//订单ID
	private Product product;//商品ID
	private int quantity;//商品质量
	
	/**
	 * 默认构造方法
	 */
	public Orderitem() {
		super();
	}
	
	/**
	 * 不带主键的构造方法
	 * @param orders	订单
	 * @param product	商品
	 * @param quantity	商品质量
	 */
	public Orderitem(Orders orders, Product product, int quantity) {
		super();
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * 带所有参数的构造方法
	 * @param oiid		订单项ID
	 * @param oid		订单
	 * @param pid		商品
	 * @param quantity	商品质量
	 */
	public Orderitem(int oiid, Orders orders, Product product, int quantity) {
		super();
		this.oiid = oiid;
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the oiid
	 */
	public int getOiid() {
		return oiid;
	}

	/**
	 * @param oiid the oiid to set
	 */
	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	/**
	 * @return the orders
	 */
	public Orders getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}
