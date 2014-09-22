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
 * 对订单操作接口的测试
 * @author 娄赫曦   俞丹 
 * @version 1.1
 * created: 2013-06-08
 * modify: 2013-06-09 金轶伦
 */

public class TestOrderDAO extends TestCase {
	OrderDAO test = new OrderDAOImpl();
	/**
	 * 测试查找所有订单的方法
	 */
	@Test
	public void testFindAllOrders()  {
		
		

		List<Orders> orders = test.findAllOrders();
		assertEquals("Not all orders!",4,orders.size());
	}
	
	/**
	 *测试根据用户标识号查找用户所有订单的方法
	 */
	@Test
	public void testFindOrdersOfUser(){
		
		List<Orders> orders1 = test.findOrdersOfUser(1);
		assertEquals("Not all orders of this user!",2,orders1.size());
	}
	
	/**
	 * 测试根据订单的标识号查找订单的方法
	 */
	@Test
	public void testFindOrderList(){
		
		Orders order = test.findOrderList("1");
		assertEquals("Wrong order!",1,order.getOid());
		assertEquals("Wrong order!",1,order.getUser().getUserID());
	}	
	/**
	 * 测试从订单中删除商品的方法
	 */
	@Test
	public void testDeleteProductFromOrder(){
		assertEquals("Delete product failed!",1,test.deleteOrderItem(1));
	}
	/**
	 * 测试软删除订单放入方法
	 */
	@Test
	public void testDelSoftOrders(){
		assertEquals("softdelete failed!",1,test.delSoftOrders(1,'0'));
	}
		

	
	/**
	 * 测试保存订单的方法
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
