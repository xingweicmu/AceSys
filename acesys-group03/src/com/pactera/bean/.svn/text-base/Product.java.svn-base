/**
 * 存放数据封装类
 */
package com.pactera.bean;

import java.io.Serializable;

/**
 * 商品类
 * @author Brandon
 * @version 1.0
 * created: 2013-06-06
 */
public class Product implements Serializable {

	private int productID;  // 商品标识符
	private String productNumber; // 商品编号
	private ProductCategory category; //商品种类
	private String cas;  // 化学文摘登记号
	private String productName;  // 药品名称
	private String imageName;  //分子结构图地址
	private String mdlNumber;  // MDL号
	private String formula; // 化学方程式
	private double weight;  // 总重量
	private double normalPrice;  // 普通会员价格
	private double vipPrice;  // 高级会员价格
	private int stock; // 库存
	private int realStock; // 实际库存
	private char newProduct;  // 是否为新产品
	private String note;  // 备注
	private char del_soft = '0'; // 软删除值
	
	/**
	 * 默认构造函数
	 */
	public Product() {
		super();
	}

	/**
	 * 给定商品标识符，商品名，类别名和商品编号的构造函数
	 * @param productID 商品标识符
	 * @param productNumber 商品编号
	 * @param category 商品种类
	 * @param productName 商品名
	 */
	public Product(int productID, String productNumber,
			ProductCategory category, String productName) {
		super();
		this.productID = productID;
		this.productNumber = productNumber;
		this.category = category;
		this.productName = productName;
	}

	
	/**
	 * 给定详细信息的构造函数
	 * @param productID 商品标识号
	 * @param productNumber 商品编号
	 * @param category 商品种类
	 * @param cas 化学文摘登记号
	 * @param productName 商品名
	 * @param imageName 分子机构图地址
	 * @param mdlNumber MDL号 
	 * @param formula 化学公式
	 * @param weight 商品总质量
	 * @param normalPrice 普通会员价格
	 * @param vipPrice 高级会员价格
	 * @param stock 库存
	 * @param realStock 实际库存
	 * @param newProduct 新产品标记
	 * @param note 备注
	 */
	public Product(int productID, String productNumber,
			ProductCategory category, String cas, String productName,
			String imageName, String mdlNumber, String formula, double weight,
			double normalPrice, double vipPrice, int stock, int realStock,
			char newProduct, String note) {
		super();
		this.productID = productID;
		this.productNumber = productNumber;
		this.category = category;
		this.cas = cas;
		this.productName = productName;
		this.imageName = imageName;
		this.mdlNumber = mdlNumber;
		this.formula = formula;
		this.weight = weight;
		this.normalPrice = normalPrice;
		this.vipPrice = vipPrice;
		this.stock = stock;
		this.realStock = realStock;
		this.newProduct = newProduct;
		this.note = note;
	}

	/**
	 * 返回商品标识符
	 * @return 商品标识符
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * 设置商品标识符
	 * @param productID 新商品标识符
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * 返回商品编号
	 * @return 商品编号
	 */
	public String getProductNumber() {
		return productNumber;
	}

	/**
	 * 设置商品编号
	 * @param productNumber 新商品编号
	 */
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	/**
	 * 返回商品种类
	 * @return 商品种类
	 */
	public ProductCategory getCategory() {
		return category;
	}

	/**
	 * 设置商品种类
	 * @param category 商品种类
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	/**
	 * 返回化学文摘标记号
	 * @return 化学文摘标记号
	 */
	public String getCas() {
		return cas;
	}

	/**
	 * 设置化学文摘标记号
	 * @param cas 化学文摘标记号
	 */
	public void setCas(String cas) {
		this.cas = cas;
	}

	/**
	 * 返回商品名
	 * @return 商品名
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置商品名
	 * @param productName 新商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 返回分子机构图地址
	 * @return 分子结构图地址
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * 设置分子结构图地址
	 * @param imageName 分子结构图地址
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * 返回MDL号
	 * @return MDL号
	 */
	public String getMDLNumber() {
		return mdlNumber;
	}

	/**
	 * 设置MDL号
	 * @param mdlNumber MDL号
	 */
	public void setMDLNumber(String mdlNumber) {
		this.mdlNumber = mdlNumber;
	}

	/**
	 * 返回化学公式
	 * @return 化学公式
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * 设置化学公式
	 * @param formula 新化学公式
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * 返回商品总质量
	 * @return 商品总质量
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * 设置商品总质量
	 * @param weight 商品总质量
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * 返回普通会员价格
	 * @return 普通会员价格
	 */
	public double getNormalPrice() {
		return normalPrice;
	}

	/**
	 * 设置普通会员价格
	 * @param normalPrice 普通会员价格
	 */
	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}

	/**
	 * 返回高级会员价格
	 * @return 高级会员价格
	 */
	public double getVipPrice() {
		return vipPrice;
	}

	/**
	 * 设置高级会员价格
	 * @param vipPrice 高级会员价格
	 */
	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}

	/**
	 * 返回库存量
	 * @return 库存量
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 设置库存量
	 * @param stock 库存量
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 返回实际库存量
	 * @return 实际库存量
	 */
	public int getRealStock() {
		return realStock;
	}

	/**
	 * 设置实际库存量
	 * @param realStock 实际库存量
	 */
	public void setRealStock(int realStock) {
		this.realStock = realStock;
	}

	/**
	 * 返回是否是新产品
	 * @return 是否是新产品
	 */
	public char isNewProduct() {
		return newProduct;
	}

	/**
	 * 设置新产品标记符
	 * @param newProduct 是否为新产品
	 */
	public void setNewProduct(char newProduct) {
		this.newProduct = newProduct;
	}

	/**
	 * 返回备注
	 * @return 备注
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 设置备注
	 * @param note 备注
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 返回软删除值，0为正常，1为已删除
	 * @return 软删除值
	 */
	public char getDel_soft() {
		return del_soft;
	}

	/**
	 * 设置软删除值，0为正常，1为已删除
	 * @param del_soft 软删除值
	 */
	public void setDel_soft(char del_soft) {
		this.del_soft = del_soft;
	}
	
	
	
	
	
	

}
