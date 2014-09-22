package com.pactera.dao.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Test;

import com.pactera.bean.Orderitem;
import com.pactera.bean.Orders;
import com.pactera.bean.Product;
import com.pactera.bean.ProductCategory;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.OrderDAO;
import com.pactera.dao.impl.OrderDAOImpl;

/**
 * �Զ��������ӿڵĲ���
 * @author ¦����   �ᵤ 
 * @version 1.1
 * created: 2013-06-08
 * modify: 2013-06-09 ������
 */

public class TestOrderDAO extends TestCase {
	OrderDAO test = new OrderDAOImpl();
	/**
	 * ���Բ������ж����ķ���
	 */
	@Test
	public void testFindAllOrders()  {
		
		

		List<Orders> orders = test.findAllOrders();
		assertEquals("Not all orders!",4,orders.size());
	}
	
	/**
	 *���Ը����û���ʶ�Ų����û����ж����ķ���
	 */
	@Test
	public void testFindOrdersOfUser(){
		
		List<Orders> orders1 = test.findOrdersOfUser(1);
		assertEquals("Not all orders of this user!",2,orders1.size());
	}
	
	/**
	 * ���Ը��ݶ����ı�ʶ�Ų��Ҷ����ķ���
	 */
	@Test
	public void testFindOrderList(){
		
		Orders order = test.findOrderList("1");
		assertEquals("Wrong order!",1,order.getOid());
		assertEquals("Wrong order!",1,order.getUser().getUserID());
	}	
	/**
	 * ���ԴӶ�����ɾ����Ʒ�ķ���
	 */
	@Test
	public void testDeleteProductFromOrder(){
		assertEquals("Delete product failed!",1,test.deleteOrderItem(1));
	}
	/**
	 * ������ɾ���������뷽��
	 */
	@Test
	public void testDelSoftOrders(){
		assertEquals("softdelete failed!",1,test.delSoftOrders(1,'0'));
	}
		

	
	/**
	 * ���Ա��涩���ķ���
	 */
	@Test
	public void testSaveOrder(){
		User user=new User(2, "test", "123", UserRole.NORMAL);
		Orders order=new Orders(user, "2013-01-02 12:00", "2013-01-02 12:30", '0', '1');
		order.setOid(10);
		
		Product product=new Product(1, "A100", ProductCategory.WESTMEDICINE, "testproduct");
		
		Orderitem orderitem1 = new Orderitem(10, order, product, 10);
		Orderitem orderitem2 = new Orderitem(11, order, product, 11);
		
		ArrayList<Orderitem> orderitems=new ArrayList<Orderitem>();
		orderitems.add(orderitem1);
		orderitems.add(orderitem2);
		assertEquals("Save failed!",1,test.saveOrder(order,orderitems));
	}

}
