/**
 * 存放数据封装类
 */
package com.pactera.bean;

import java.io.Serializable;

/**
 * 订单表类
 * @author 金轶伦
 * @version 1.0
 * create 2013-06-06
 */
public class Orders implements Serializable {
	private int oid;//订单ID
	private User user;//客户
	private String starttime;//生成订单的时间
	private String endtime;//订单完成时间
	private char delsoft;//软删除（0存在 1 删除）
	private char status;//订单状态
	
	/**
	 * 默认构造方法
	 */
	public Orders() {
		super();
	}
	
	/**
	 * 不带主键的构造方法
	 * @param user		客户
	 * @param starttime	生成订单的时间
	 * @param endtime	订单完成时间
	 * @param delsoft	软删除（0存在 1 删除）
	 * @param status	订单状态
	 */
	public Orders(User user, String starttime, String endtime, char delsoft,
			char status) {
		super();
		this.user = user;
		this.starttime = starttime;
		this.endtime = endtime;
		this.delsoft = delsoft;
		this.status = status;
	}
	
	/**
	 * 带所有参数的构造方法
	 * @param oid		订单ID
	 * @param user		客户
	 * @param starttime	生成订单的时间
	 * @param endtime	订单完成时间
	 * @param delsoft	软删除（0存在 1 删除）
	 * @param status	订单状态
	 */
	public Orders(int oid, User user, String starttime, String endtime,
			char delsoft, char status) {
		super();
		this.oid = oid;
		this.user = user;
		this.starttime = starttime;
		this.endtime = endtime;
		this.delsoft = delsoft;
		this.status = status;
	}

	/**
	 * @return the oid
	 */
	public int getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the endtime
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return the delsoft
	 */
	public char getDelsoft() {
		return delsoft;
	}

	/**
	 * @param delsoft the delsoft to set
	 */
	public void setDelsoft(char delsoft) {
		this.delsoft = delsoft;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
