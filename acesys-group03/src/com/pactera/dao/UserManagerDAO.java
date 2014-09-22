/**
 * ����ϵͳҵ��ӿں����ݽӿ�
 */
package com.pactera.dao;

import java.util.List;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;

/**
 * ����Ա���û������ӿ�
 * @author David.Wei
 * @version 1.0
 * created: 2013-06-06
 */
public interface UserManagerDAO {

	/**
	 * ϵͳ����Ա�����û�
	 * @param newUser ���û�
	 * @return �Ƿ�ɹ�����û� 1:�ɹ���� 0�����ʧ��
	 */
	int addProductUser(User newUser);
	
	/**
	 * ϵͳ����Ա��ѯȫ��ϵͳ�û�����
	 * @return �����û������б�
	 */
	List<User> findAllProductUsr();
	
	/**
	 * ϵͳ����Աͨ���û�����id��ȡ�û�����
	 * @param uid �û�����Id
	 * @return ��ѯ�����û�����
	 */
	User findUserById(int uid);
	
	/**
	 * ϵͳ����Աͨ���û�����ȡ�û�������Ȳ�ѯ��
	 * @param username �û���
	 * @return ��ѯ�����û�����
	 */
	User findUserByUsername(String username);
	
	/**
	 * ע�Ṧ�ܣ��ж��û����Ƿ����
	 * @param username �û���
	 * @return �û����Ƿ���� 
	 */
	boolean opName(String username);
	
	/**
	 * ϵͳ����Ա�����û���Ϣ
	 * @param theUser �����µ��û�����
	 * @return �Ƿ���³ɹ� 1�����³ɹ� 0�������û���Ϣʧ��
	 */
	int updateUser(User theUser);
	
	/**
	 * ϵͳ����Ա�����û���ɫ
	 * @param uid �û���ʶ��
	 * @param theRole �û���ɫ����
	 * @return �Ƿ���½�ɫ�ɹ�  1�����³ɹ� 0�������û���Ϣʧ��
	 */
	int updateUserRole(int uid, UserRole theRole);
	
	/**
	 * ��ɾ���û�
	 * @param uid �û���ʶ��
	 * @param delSoft ��ɾ����ʶ
	 * @return �Ƿ���ɾ���ɹ� 1����ɾ���ɹ� 0����ɾ��ʧ��
	 */
	int delSoftUser(int uid, char delSoft);
	
	/**
	 * �޸��û�����
	 * @param uid �û���ʶ��
	 * @param oldPassword ������
	 * @param newPassword ������
	 * @return
	 */
	int updatePassword(int uid, String oldPassword, String newPassword);
}
