/**
 * ����ϵͳҵ��ӿں����ݽӿ�
 */ 
package com.pactera.dao;

import com.pactera.bean.Mailtb;

/**
 * ���ʼ������Ľӿ�
 * @author David.Wei
 * @version 1.0
 * created: 2013-06-06
 */
public interface MailDAO {

	/**
	 * ��ѯ�ʼ�  
	 * @return Mailtb �ʼ�����
	 */
	Mailtb findMail();
	
	/**
	 * ��������ʼ�
	 * @param theMail �ʼ�����
	 * @return �Ƿ�ɹ����� 1���ɹ����� 0������ʧ��
	 */
	int saveMail(Mailtb theMail);
	
//	/**
//	 * ɾ���ʼ�
//	 * @param theMail �ʼ�����
//	 * @return �Ƿ�ɹ�ɾ�� 1���ɹ�ɾ�� 0��ɾ��ʧ��
//	 */
//	int deleteMail(Mailtb theMail);
//	
//	/**
//	 * �����ʼ�
//	 * @param theMail ���������͵��ʼ�����
//	 * @return �Ƿ�ɹ������ʼ� 1���ɹ������ʼ� 0�������ʼ�ʧ��
//	 */
//	int sendMail(Mailtb theMail);
}
