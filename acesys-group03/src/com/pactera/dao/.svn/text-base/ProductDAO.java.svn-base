/**
 * 描述系统业务接口和数据接口
 */
package com.pactera.dao;

import java.util.List;

import com.pactera.bean.Product;

/**
 * 对商品操作的接口
 * @author David.Wei
 * @version 1.0
 * create:2013-06-06
 */
public interface ProductDAO {
	
	/**
	 * 获取所有商品列表
	 * @param flag 0表示普通用户查询所有查询 1表示管理员查询所有查询（含软删除）
	 * @return 所有商品的数组列表
	 */
	List<Product> getALLProduct(int flag);
	
	/**
	 * 根据商品标识号查询商品
	 * @param theProductId 商品标识号
	 * @return 商品对象
	 */
	Product findProductByProductId(int theProductId);
	
//	/**
//	 * 根据商品编号查询商品
//	 * @param theProductNumber 商品编号
//	 * @return 商品对象
//	 */
//	Product findProductByProductNumber(String theProductNumber);
	
	/**
	 * 软删除商品
	 * @param pid 商品标识号
	 * @param delSoft 软删除标识
	 * @return 是否成功 1：成功软删除 0： 软删除失败
	 */
	int delSoftProdcut(int pid, char delSoft);
	
	/**
	 * 添加商品
	 * @param theProduct 商品对象
	 * @return 是否成功添加 1：成功添加 0：添加失败
	 */
	int insertProduct(Product theProduct);
	
	/**
	 * 更新商品信息
	 * @param theProduct 商品对象
	 * @return 是否更新添加 1：更新成功 0：更新失败
	 */
	int updateProductInfo(Product theProduct);
	
//	/**
//	 * 根据商品分类名称查询商品
//	 * @param theCategoryName 商品分类名称
//	 * @return 商品列表
//	 */
//	List<Product> findProductsByCategoryName(String theCategoryName);	
//	
//	/**
//	 * 根据商品名称查询商品
//	 * @param theProductName 商品名称
//	 * @return 商品
//	 */
//	Product findProductsByProductName(String theProductName);	
//	
//	/**
//	 * 根据商品分类号查询商品
//	 * @param theCategoryNo 商品分类号
//	 * @return 商品列表
//	 */
//	List<Product> findProductsByCategoryNo(String theCategoryNo);		
//	
	/**
	 * 根据商品名称、商品编号、商品分类名称、商品你分类号查询商品（模糊查询）
	 * @param searchName 商品查询种类：商品名称、商品编号、商品分类名称、商品你分类号
	 * @param searchValue 商品查询关键字
	 * @return 商品列表
	 */
	List<Product> findProducts(String searchName, String searchValue);
}
