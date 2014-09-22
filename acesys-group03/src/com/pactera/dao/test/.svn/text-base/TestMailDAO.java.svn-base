package com.pactera.dao.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import com.pactera.bean.Mailtb;
import com.pactera.dao.MailDAO;
import com.pactera.dao.impl.MailDAOImpl;

import org.junit.Test;

/**
 * 对邮件操作接口的测试
 * @author 娄赫曦   俞丹
 * @version 1.0
 * created: 2013-06-08
 */
public class TestMailDAO extends TestCase{

	@Test
	public void testMail() {
		
		MailDAO test = new MailDAOImpl();
		//Mailtb mail = new Mailtb("admin@163.com","123","guest@163.com");
		
		/**
		 * 测试查找邮件的方法
		 */
		Mailtb mailtb = test.findMail();
		
		assertEquals("Find failed!","admin@163.com", mailtb.getFromaddress());
		assertEquals("Find failed!","123", mailtb.getFrompassword());
		assertEquals("Find failed!","guest@163.com", mailtb.getToaddress());
		
		/**
		 * 测试保存邮件的方法
		 */
		assertEquals("Save failed!",1,test.saveMail(mailtb));
	
//		/**
//		 * 测试删除邮件的方法
//		 */
//		assertEquals("Delete failed!",0, test.deleteMail(mailtb));
//		
//		/**
//		 * 色是发送邮件的方法
//		 */
//		assertEquals("Send failed!",0, test.sendMail(mailtb));
	}

}
