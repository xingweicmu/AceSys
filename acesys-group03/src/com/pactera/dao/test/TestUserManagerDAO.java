/**
 * 
 */
package com.pactera.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.UserManagerDAO;
import com.pactera.dao.impl.UserManagerDAOImpl;

/**
 * 对UserManager类进行单元测试
 * @author Brandon
 * @version 1.0
 * created: 2013-06-08
 */
public class TestUserManagerDAO {
	
	private UserManagerDAO userManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userManager = new UserManagerDAOImpl();
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#addProductUser(com.pactera.bean.User)}.
	 */
	@Test
	public void testAddProductUser() {
		User user = new User();
		user.setUserName("Kevin");
		user.setPassword("123");
		user.setCompanyName("NEU");
		user.setCity("Shenyang");
		user.setJob("Software Engineering");
		user.setTel("18809891354");
		user.setEmail("hello1354@163.com");
		user.setCountry("CN");
		user.setZip("100819");
		user.setCompanyAddress("Shenyang");
		user.setRole(UserRole.VIP);
		user.setNote("Hello");
		user.setFullName("Kevin G");
		int result = userManager.addProductUser(user);
		assertEquals("Result Incorrect", 1, result);
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#findUserById(int)}.
	 */
	@Test
	public void testFindUserById() {
		User user = userManager.findUserById(1);
		assertEquals("Return User Incorrect", "admin", user.getUserName());
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#findUserByUsername(java.lang.String)}.
	 */
	@Test
	public void testFindUserByUsername() {
		User user = userManager.findUserByUsername("a");
		assertEquals("Return User Incorrect", 2, user.getUserID());
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#opName(java.lang.String)}.
	 */
	@Test
	public void testOpName() {
		boolean result = userManager.opName("admin");
		assertTrue("User not exist", result);
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#updateUser(com.pactera.bean.User)}.
	 */
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUserName("Jason");
		user.setPassword("123");
		user.setCompanyName("NEU");
		user.setCity("Shenyang");
		user.setJob("Software Engineering");
		user.setTel("18809891321");
		user.setEmail("jason@163.com");
		user.setCountry("CN");
		user.setZip("100819");
		user.setCompanyAddress("Shenyang");
		user.setRole(UserRole.VIP);
		user.setNote("Hello");
		user.setFullName("Jason King");
		userManager.addProductUser(user);
		user = userManager.findUserByUsername("Jason");
		String change = "Change info";
		user.setNote(change);
		int result = userManager.updateUser(user);
		assertEquals("update Incorrect", 1, result);
		User findUser = userManager.findUserById(user.getUserID());
		assertEquals("Update Incrrect", change, findUser.getNote());
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#updateUserRole(int, com.pactera.bean.UserRole)}.
	 */
	@Test
	public void testUpdateUserRole() {
		int result = userManager.updateUserRole(3, UserRole.VIP);
		assertEquals("Update Incorrect", 1, result);
		User user = userManager.findUserById(3);
		assertEquals("Update Incrrect", UserRole.VIP, user.getRole());
	}

	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#delSoftUser(int, char)}.
	 */
	@Test
	public void testDelSoftUser() {
		int result = userManager.delSoftUser(3, '1');
		assertEquals("Update Incorrect", 1, result);
		User user = userManager.findUserById(3);
		assertEquals("Update Incrrect", '1', user.getDelsoft());
	}
	
	/**
	 * Test method for {@link com.pactera.dao.UserManagerDAO#updatePassword(int, String, String)}
	 */
	@Test
	public void testUpdatePassword() {
		int result = userManager.updatePassword(2, "321", "123");
		assertEquals("Update Incorrect", 1, result);
		User user = userManager.findUserById(2);
		assertEquals("Update Incrrect", "123", user.getPassword());
	}

}
