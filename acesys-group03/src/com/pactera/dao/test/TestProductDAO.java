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
 * ����Ʒ�����ӿڵĲ���
 * @author ¦����   �ᵤ
 * @version 1.0
 * created: 2013-06-08
 * modify: 2013-06-014 David.Wei 
 */
public class TestProductDAO {

	@Test
	public void test() {
		
		ProductDAO test= new ProductDAOImpl();
		
		/**
		 * �����Թ���Ա��ݻ�ȡ������Ʒ�ķ���
		 */
//		ArrayList<Product> products = test.getALLProduct(1);
//		assertEquals("Not all products!",4,products.size());
		
		/**
		 * �������û���ݻ�ȡ������Ʒ�ķ���
		 */
//		ArrayList<Product> products1 = test.getALLProduct(0);
//		assertEquals("Not all products!",2,products1.size());
		
		/**
		 * ���԰�����Ʒ��ʶ�Ų�����Ʒ�ķ���
		 */
//		Product product = test.findProductByProductId(1);
//		assertEquals("Wrong product!",1,product.getProductID());
		
		/**
		 * ���԰�����Ʒ��Ų�����Ʒ�ķ���
		 */
		List<Product> products = test.findProducts("product_number","A001");
		assertEquals("Wrong product!",1,products.size());
		
		/**
		 * ���԰�����Ʒ���Ʋ�����Ʒ�ķ���
		 */
		List<Product> products2 = test.findProducts("productname","zhitong");
		assertEquals("Wrong product!",1,products2.size());
		
		/**
		 * ���Ը�����Ʒ�������Ʋ�ѯ��Ʒ�ķ���
		 */
		List<Product> products3 = test.findProducts("category_name","xiyao");
		assertEquals("Not all products!",2,products3.size());
		
		/**
		 * ���Ը�����Ʒ����Ų�ѯ��Ʒ�ķ���
		 */
		List<Product> products4 = test.findProducts("categoryno","002");
		assertEquals("Not all products!",1,products4.size());
//
//		/**
//		 * ������ɾ����Ʒ�ķ���
//		 */
//		assertEquals("Softdelete failed!",1,test.delSoftProdcut(1,'1'));
//		assertEquals("Softdelete failed!",4,test.getALLProduct(1).size());
//		assertEquals("Softdelete failed!",2,test.getALLProduct(0).size());
//		
//		/**
//		 * ���Բ�����Ʒ�ķ���
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
//		 * ���Ը�����Ʒ��Ϣ�ķ���
//		 */
//		Product update_product = test.findProductByProductId(1);
//		update_product.setProductName("Just for a test");
//		assertEquals("Update failed!",1,test.updateProductInfo(update_product));
//		System.out.println(test.findProductByProductId(1).getNote());
//		assertEquals("Update failed!","Just for a test",test.findProductByProductId(1).getProductName());		
		
	}
}
