/**
 * 
 */
package com.pactera.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.pactera.bean.User;
import com.pactera.dao.UserManagerDAO;
import com.pactera.dao.impl.UserManagerDAOImpl;

/**
 * 针对UserManagerDAO接口中的findAllUsers方法进行测试
 * @author Brandon
 * @version 1.0 
 * created: 2013-06-08
 */
public class TestUserManagerDAOFindAllUsers {

	private UserManagerDAO userManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userManager = new UserManagerDAOImpl();
	}

	/**
	 * Test method for
	 * {@link com.pactera.dao.UserManagerDAO#findAllProductUsr()}.
	 */
	@Test
	public void testFindALlProductUsr() {
		ArrayList<User> userList = (ArrayList<User>) userManager
				.findAllProductUsr();
		assertEquals("User Amount Incorrect", 6, userList.size());
	}

}
