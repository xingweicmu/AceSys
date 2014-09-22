/**
 * 存放数据封装类
 */
package com.pactera.bean;

import java.io.Serializable;

/**
 * 用户权限类
 * 用户权限包括管理员，高级用户，普通用户
 * @author Brandon
 * @version 1.0
 * created: 2013-06-06
 */
public enum UserRole implements Serializable {
	
	/**
	 * 管理员
	 */
	MANAGER("Manager", '3'),
	/**
	 * 高级用户
	 */
	VIP("VIP User", '2'),
	/**
	 * 普通用户
	 */
	NORMAL("Normal User", '1');
	
	private String RoleName;   //role's name
	private char right;  //role's right
	
	/**
	 * 私有的构造函数
	 * 
	 * @param name 角色名
	 * @param right 角色权限
	 */ 
	private UserRole(String name, char right) {
		RoleName = name;
		this.right = right;
	}
	
	public char getRight() {
		return right;
	}
}
