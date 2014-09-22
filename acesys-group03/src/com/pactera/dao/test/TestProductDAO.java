package com.pactera.dao.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.pactera.bean.Product;
import com.pactera.bean.ProductCategory;
import com.pactera.dao.ProductDAO;
import com.pactera.dao.impl.ProductDAOImpl;

/**
 * 对商品操作接口的测试
 * @author 娄赫曦   俞丹
 * @version 1.0
 * created: 2013-06-08
 * modify: 2013-06-014 David.Wei 
 */
public class TestProductDAO {

	@Test
	public void test() {
		
		ProductDAO test= new ProductDAOImpl();
		
		/**
		 * 测试以管理员身份获取所有商品的方法
		 */
//		ArrayList<Product> products = test.getALLProduct(1);
//		assertEquals("Not all products!",4,products.size());
		
		/**
		 * 测试以用户身份获取所有商品的方法
		 */
//		ArrayList<Product> products1 = test.getALLProduct(0);
//		assertEquals("Not all products!",2,products1.size());
		
		/**
		 * 测试按照商品标识号查找商品的方法
		 */
//		Product product = test.findProductByProductId(1);
//		assertEquals("Wrong product!",1,product.getProductID());
		
		/**
		 * 测试按照商品编号查找商品的方法
		 */
		List<Product> products = test.findProducts("product_number","A001");
		assertEquals("Wrong product!",1,products.size());
		
		/**
		 * 测试按照商品名称查找商品的方法
		 */
		List<Product> products2 = test.findProducts("productname","zhitong");
		assertEquals("Wrong product!",1,products2.size());
		
		/**
		 * 测试根据商品分类名称查询商品的方法
		 */
		List<Product> products3 = test.findProducts("category_name","xiyao");
		assertEquals("Not all products!",2,products3.size());
		
		/**
		 * 测试根据商品分类号查询商品的方法
		 */
		List<Product> products4 = test.findProducts("categoryno","002");
		assertEquals("Not all products!",1,products4.size());
//
//		/**
//		 * 测试软删除商品的方法
//		 */
//		assertEquals("Softdelete failed!",1,test.delSoftProdcut(1,'1'));
//		assertEquals("Softdelete failed!",4,test.getALLProduct(1).size());
//		assertEquals("Softdelete failed!",2,test.getALLProduct(0).size());
//		
//		/**
//		 * 测试插入商品的方法
//		 */
//		Product product3= new Product();
//		product3.setProductName("TESTPRODUCT");
//		product3.setCategory(ProductCategory.WESTMEDICINE);
//		product3.setWeight(5.00);
//		assertEquals("Insert failed!",1,test.insertProduct(product3));
//		assertEquals("Insert failed!",5,test.getALLProduct(1).size());
//		assertEquals("Insert failed!","TESTPRODUCT",test.findProductByProductId(6).getProductName());
//		
//		/**
//		 * 测试更新商品信息的方法
//		 */
//		Product update_product = test.findProductByProductId(1);
//		update_product.setProductName("Just for a test");
//		assertEquals("Update failed!",1,test.updateProductInfo(update_product));
//		System.out.println(test.findProductByProductId(1).getNote());
//		assertEquals("Update failed!","Just for a test",test.findProductByProductId(1).getProductName());		
		
	}
}
