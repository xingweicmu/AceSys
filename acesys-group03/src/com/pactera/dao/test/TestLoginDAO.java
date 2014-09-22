package com.pactera.dao.test;

import org.junit.Test;

import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.loginDAO;
import com.pactera.dao.impl.LoginDAOImpl;
import junit.framework.TestCase;

/**
 * 对ProductDAOImpl类进行单元测试
 * @author David.Wei
 * @version 1.0
 * created: 2013-06-08
 */
public class TestLoginDAO extends TestCase {

	/**
	 * 管理员登陆测试
	 * Test method for {@link com.pactera.dao.UserManagerDAO#login(String,String)}.
	 */
	@Test
	public void testLoginManager(){
		loginDAO test= new LoginDAOImpl();
		User user = test.login("admin", "123");
		assertEquals("Wrong user!",1,user.getUserID());
		assertEquals("Wrong user!","admin",user.getUserName());
		assertEquals("Wrong user!",UserRole.MANAGER,user.getRole());
//		assertEquals("Wrong user!",null,user.getPassword());
//		assertEquals("Wrong user!","hisoft",user.getCompanyName());
//		assertEquals("Wrong user!","beijing",user.getCity());
//		assertEquals("Wrong user!","teacher",user.getJob());
//		assertEquals("Wrong user!","18610554598",user.getTel());
//		assertEquals("Wrong user!","yu.zhang9@hisoft.com",user.getUserID());
//		assertEquals("Wrong user!","CN",user.getUserID());
//		assertEquals("Wrong user!","100085",user.getUserID());
//		assertEquals("Wrong user!","shangdi",user.getUserID());
//		assertEquals("Wrong user!",null,user.getUserID());
//		assertEquals("Wrong user!","100085",user.getUserID());
		
	}
	
	/**
	 * VIP用户登陆测试
	 * Test method for {@link com.pactera.dao.UserManagerDAO#login(String,String)}.
	 */
	@Test
	public void testLoginVIPUser(){
		loginDAO test= new LoginDAOImpl();
		User user = test.login("a", "123");
		assertEquals("Wrong user!",2,user.getUserID());
		assertEquals("Wrong user!","a",user.getUserName());
		assertEquals("Wrong user!",UserRole.VIP,user.getRole());
		//assertEquals("Wrong user!",null,user.getPassword());
	}
	
	/**
	 * VIP用户登陆测试
	 * Test method for {@link com.pactera.dao.UserManagerDAO#login(String,String)}.
	 */
	@Test
	public void testLoginNormalUser(){
		loginDAO test= new LoginDAOImpl();
		User user = test.login("b", "123");
		assertEquals("Wrong user!",3,user.getUserID());
		assertEquals("Wrong user!","b",user.getUserName());
		assertEquals("Wrong user!",UserRole.NORMAL,user.getRole());
		//assertEquals("Wrong user!",null,user.getPassword());
	}
	
	/**
	 * 不存在的用户登陆测试
	 * Test method for {@link com.pactera.dao.UserManagerDAO#login(String,String)}.
	 */
	@Test
	public void testLoginWithoutUser(){
		loginDAO test= new LoginDAOImpl();
		User user = test.login("Notexist", "123");
		assertNull("Wrong user!",user);
	}
	
	/**
	 * 用户输错密码登陆测试
	 * Test method for {@link com.pactera.dao.UserManagerDAO#login(String,String)}.
	 */
	@Test
	public void testLoginWithWrongPassword(){
		loginDAO test= new LoginDAOImpl();
		User user = test.login("admin", "1234");
		assertNull("Wrong user!",user);
	}	
	
}
