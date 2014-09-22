package com.pactera.dao.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import com.pactera.bean.Mailtb;
import com.pactera.dao.MailDAO;
import com.pactera.dao.impl.MailDAOImpl;

import org.junit.Test;

/**
 * ���ʼ������ӿڵĲ���
 * @author ¦����   �ᵤ
 * @version 1.0
 * created: 2013-06-08
 */
public class TestMailDAO extends TestCase{

	@Test
	public void testMail() {
		
		MailDAO test = new MailDAOImpl();
		//Mailtb mail = new Mailtb("admin@163.com","123","guest@163.com");
		
		/**
		 * ���Բ����ʼ��ķ���
		 */
		Mailtb mailtb = test.findMail();
		
		assertEquals("Find failed!","admin@163.com", mailtb.getFromaddress());
		assertEquals("Find failed!","123", mailtb.getFrompassword());
		assertEquals("Find failed!","guest@163.com", mailtb.getToaddress());
		
		/**
		 * ���Ա����ʼ��ķ���
		 */
		assertEquals("Save failed!",1,test.saveMail(mailtb));
	
//		/**
//		 * ����ɾ���ʼ��ķ���
//		 */
//		assertEquals("Delete failed!",0, test.deleteMail(mailtb));
//		
//		/**
//		 * ɫ�Ƿ����ʼ��ķ���
//		 */
//		assertEquals("Send failed!",0, test.sendMail(mailtb));
	}

}
