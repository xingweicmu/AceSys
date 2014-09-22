/**
 * 描述系统业务接口和数据接口
 */
package com.pactera.dao;

import java.util.ArrayList;
import java.util.List;

import com.pactera.bean.Orderitem;
import com.pactera.bean.Orders;
/**
 * 对订单操作的接口
 * @author David.Wei
 * @version 1.0
 * create:2013-06-06
 */
public interface OrderDAO {

	/**
	 * 保存用户订单
	 * @return 是否成功保存订单 1：成功保存订单 0：保存订单失败
	 */
	int saveOrder(Orders order,ArrayList<Orderitem> orderItems);  
	//1.对用户信息更新（urs表）updateUser(con,user)
	//2.插入订单表 insertOrder(con,order) 
	//3.订单项表里插入多条信息 insertItem(con,List) 
	//4.更新商品数量updateItem(con,product)
	
	/**
	 * 通过订单标识号寻找订单
	 * @param oid 被寻找的订单标识号
	 * @return 寻找到的订单
	 */
	Orders findOrderList(String oid);

	
	/**
	 * 查询所有订单
	 * @return 订单列表
	 */
	List<Orders> findAllOrders();
	
	/**
	 * 根据用户标识号查找用户所有订单
	 * @param uid 用户标识号
	 * @return 订单列表
	 */	
	List<Orders> findOrdersOfUser(int uid);
	
	/**
	 * 从订单中删除订单项
	 * @param oiid 订单项标识号
	 * @return 是否成功删除商品 1：成功删除 0：删除失败
	 */
	int deleteOrderItem(int oiid);
	
	/**
	 * 软删除订单
	 * @param oid 订单标识号
	 * @return 是否成功软删除商品 1：成功软删除 0：软删除失败
	 */
	int delSoftOrders(int oid, char delsoft);	
	
}
