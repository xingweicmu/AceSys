/**
 * ����ϵͳҵ��ӿں����ݽӿ�
 */
package com.pactera.dao;

import com.pactera.bean.User;

/**
 * ��½�����ӿ�
 * @author David.Wei
 * @version 1.0
 * create:2013-06-06
 */
public interface loginDAO {

	/**
	 * ��½
	 * @param username �û���
	 * @param passwd �û�����
	 * @return �ѵ�¼�û�����
	 */
	User login(String username, String passwd);
}
