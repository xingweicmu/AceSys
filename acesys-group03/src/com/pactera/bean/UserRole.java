/**
 * ������ݷ�װ��
 */
package com.pactera.bean;

import java.io.Serializable;

/**
 * �û�Ȩ����
 * �û�Ȩ�ް�������Ա���߼��û�����ͨ�û�
 * @author Brandon
 * @version 1.0
 * created: 2013-06-06
 */
public enum UserRole implements Serializable {
	
	/**
	 * ����Ա
	 */
	MANAGER("Manager", '3'),
	/**
	 * �߼��û�
	 */
	VIP("VIP User", '2'),
	/**
	 * ��ͨ�û�
	 */
	NORMAL("Normal User", '1');
	
	private String RoleName;   //role's name
	private char right;  //role's right
	
	/**
	 * ˽�еĹ��캯��
	 * 
	 * @param name ��ɫ��
	 * @param right ��ɫȨ��
	 */ 
	private UserRole(String name, char right) {
		RoleName = name;
		this.right = right;
	}
	
	public char getRight() {
		return right;
	}
}
