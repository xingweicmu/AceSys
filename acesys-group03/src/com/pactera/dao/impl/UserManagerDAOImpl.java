/**
 * 
 */
package com.pactera.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.UserManagerDAO;
import com.pactera.util.DataAccess;

/**
 * UserManager类的实现类
 * 
 * @author Brandon
 * @version 1.0 
 * created: 2013-06-08
 */
public class UserManagerDAOImpl implements UserManagerDAO {

	/**
	 * 系统管理员增加用户
	 * 
	 * @see com.pactera.dao.UserManagerDAO#addProductUser(com.pactera.bean.User)
	 */
	public int addProductUser(User newUser) {
		String userName = newUser.getUserName();
		// 判断用户是否存在
		if (opName(userName)) {
			return 0;
		}

		Connection dbCon = null;
		PreparedStatement pst = null;

		try {
			String insertUser = "INSERT INTO usr (username, password, companyname, "
					+ "city, job, tel, email, country, zip, companyaddress, "
					+ "superuser, note, fullname, delsoft) VALUES (?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?);";
			dbCon = DataAccess.getConnection();
			dbCon.setAutoCommit(false); // 设置事务操作
			pst = dbCon.prepareStatement(insertUser);
			pst.setString(1, userName); // 设置相关参数
			pst.setString(2, newUser.getPassword());
			pst.setString(3, newUser.getCompanyName());
			pst.setString(4, newUser.getCity());
			pst.setString(5, newUser.getJob());
			pst.setString(6, newUser.getTel());
			pst.setString(7, newUser.getEmail());
			pst.setString(8, newUser.getCountry());
			pst.setString(9, newUser.getZip());
			pst.setString(10, newUser.getCompanyAddress());
			pst.setString(11,
					new Character(newUser.getRole().getRight()).toString());
			pst.setString(12, newUser.getNote());
			pst.setString(13, newUser.getFullName());
			pst.setString(14, new Character(newUser.getDelsoft()).toString());
			pst.execute();
			dbCon.commit();
		} catch (Exception e) {
			try {
				dbCon.rollback(); // 回滚操作
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	/**
	 * 系统管理员查询全部系统用户对象
	 * 
	 * @see com.pactera.dao.UserManagerDAO#findAllProductUsr()
	 */
	public List<User> findAllProductUsr() {
		Connection dbCon = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();

		try {
			dbCon = DataAccess.getConnection();
			st = dbCon.createStatement();
			String query = "SELECT * FROM usr;";
			rs = st.executeQuery(query);
			while (rs.next()) {
				User user = new User(); // 创建用户对象并设置相关值
				user.setUserID(rs.getInt("uid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCompanyName(rs.getString("companyname"));
				user.setCity(rs.getString("city"));
				user.setJob(rs.getString("job"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setCountry(rs.getString("country"));
				user.setZip(rs.getString("zip"));
				user.setCompanyAddress(rs.getString("companyaddress"));
				user.setNote(rs.getString("note"));
				user.setFullName(rs.getString("fullname"));
				user.setDelsoft(rs.getString("delsoft").charAt(0));
				char userRole = rs.getString("superuser").charAt(0);
				if (userRole == '1')
					user.setRole(UserRole.NORMAL);
				else if (userRole == '2')
					user.setRole(UserRole.VIP);
				else if (userRole == '3')
					user.setRole(UserRole.MANAGER);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, st, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	/**
	 * 通过用户id查找用户信息
	 * 
	 * @see com.pactera.dao.UserManagerDAO#findUserById(int)
	 */
	public User findUserById(int uid) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			dbCon = DataAccess.getConnection();
			String query = "SELECT * FROM usr WHERE uid = ?;";
			pst = dbCon.prepareStatement(query);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("uid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCompanyName(rs.getString("companyname"));
				user.setCity(rs.getString("city"));
				user.setJob(rs.getString("job"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setCountry(rs.getString("country"));
				user.setZip(rs.getString("zip"));
				user.setCompanyAddress(rs.getString("companyaddress"));
				user.setNote(rs.getString("note"));
				user.setFullName(rs.getString("fullname"));
				user.setDelsoft(rs.getString("delsoft").charAt(0));
				char userRole = rs.getString("superuser").charAt(0);
				if (userRole == '1')
					user.setRole(UserRole.NORMAL);
				else if (userRole == '2')
					user.setRole(UserRole.VIP);
				else if (userRole == '3')
					user.setRole(UserRole.MANAGER);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 通过用户名查找用户
	 * 
	 * @see com.pactera.dao.UserManagerDAO#findUserByUsername(java.lang.String)
	 */
	public User findUserByUsername(String username) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			dbCon = DataAccess.getConnection();
			String query = "SELECT * FROM usr WHERE username = ?;";
			pst = dbCon.prepareStatement(query);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("uid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCompanyName(rs.getString("companyname"));
				user.setCity(rs.getString("city"));
				user.setJob(rs.getString("job"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setCountry(rs.getString("country"));
				user.setZip(rs.getString("zip"));
				user.setCompanyAddress(rs.getString("companyaddress"));
				user.setNote(rs.getString("note"));
				user.setFullName(rs.getString("fullname"));
				user.setDelsoft(rs.getString("delsoft").charAt(0));
				char userRole = rs.getString("superuser").charAt(0);
				if (userRole == '1')
					user.setRole(UserRole.NORMAL);
				else if (userRole == '2')
					user.setRole(UserRole.VIP);
				else if (userRole == '3')
					user.setRole(UserRole.MANAGER);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 通过用户名判断用户是否存在
	 * 
	 * @see com.pactera.dao.UserManagerDAO#opName(java.lang.String)
	 */
	public boolean opName(String username) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			dbCon = DataAccess.getConnection();
			String query = "SELECT * FROM usr WHERE username = ?;";
			pst = dbCon.prepareStatement(query);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 系统管理员更新用户信息
	 * 
	 * @see com.pactera.dao.UserManagerDAO#updateUser(com.pactera.bean.User)
	 */
	public int updateUser(User theUser) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		String userName = theUser.getUserName();
		int updateRows = 0;

		try {
			dbCon = DataAccess.getConnection();
			dbCon.setAutoCommit(false); // 设置事务操作
			String update = "UPDATE usr SET username = ?, password = ?, "
					+ "companyname = ?, city = ?, job = ?, tel = ?, email = ?, "
					+ "country = ?, zip = ?, companyaddress = ?, superuser = ?, "
					+ "note = ?, fullname = ?, delsoft = ? WHERE uid = ?";
			pst = dbCon.prepareStatement(update);
			pst.setString(1, userName);
			pst.setString(2, theUser.getPassword());
			pst.setString(3, theUser.getCompanyName());
			pst.setString(4, theUser.getCity());
			pst.setString(5, theUser.getJob());
			pst.setString(6, theUser.getTel());
			pst.setString(7, theUser.getEmail());
			pst.setString(8, theUser.getCountry());
			pst.setString(9, theUser.getZip());
			pst.setString(10, theUser.getCompanyAddress());
			pst.setString(11,
					new Character(theUser.getRole().getRight()).toString());
			pst.setString(12, theUser.getNote());
			pst.setString(13, theUser.getFullName());
			pst.setString(14, new Character(theUser.getDelsoft()).toString());
			pst.setInt(15, theUser.getUserID());
			updateRows = pst.executeUpdate();
			dbCon.commit();
		} catch (Exception e) {
			try {
				dbCon.rollback(); // 出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRows;
	}

	/**
	 * 更新用户权限
	 * 
	 * @see com.pactera.dao.UserManagerDAO#updateUserRole(int,
	 *      com.pactera.bean.UserRole)
	 */
	public int updateUserRole(int uid, UserRole theRole) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int updateRows = 0;

		try {
			dbCon = DataAccess.getConnection();
			dbCon.setAutoCommit(false); // 设置事务操作
			String update = "UPDATE usr SET superuser = ? WHERE uid = ?";
			pst = dbCon.prepareStatement(update);
			pst.setString(1, new Character(theRole.getRight()).toString());
			pst.setInt(2, uid);
			updateRows = pst.executeUpdate();
			dbCon.commit();
		} catch (Exception e) {
			try {
				dbCon.rollback(); // 出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateRows;
	}

	/**
	 * 软删除用户
	 * 
	 * @see com.pactera.dao.UserManagerDAO#delSoftUser(int, char)
	 */
	public int delSoftUser(int uid, char delSoft) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int updateRows = 0;

		try {
			dbCon = DataAccess.getConnection();
			dbCon.setAutoCommit(false); // 设置事务操作
			String update = "UPDATE usr SET delsoft = ? WHERE uid = ?";
			pst = dbCon.prepareStatement(update);
			pst.setString(1, new Character(delSoft).toString());
			pst.setInt(2, uid);
			updateRows = pst.executeUpdate();
			dbCon.commit();
		} catch (Exception e) {
			try {
				dbCon.rollback(); // 出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateRows;
	}

	/**
	 * 更新用户密码
	 * 
	 * @see com.pactera.dao.UserManagerDAO#updatePassword(int, String, String)
	 */
	public int updatePassword(int uid, String oldPassword, String newPassword) {
		Connection dbCon = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int updateRows = 0;

		try {
			dbCon = DataAccess.getConnection();
			dbCon.setAutoCommit(false); // 设置事务操作
			String update = "UPDATE usr SET password = ? WHERE uid = ? AND password = ?";
			pst = dbCon.prepareStatement(update);
			pst.setString(1, newPassword);
			pst.setInt(2, uid);
			pst.setString(3, oldPassword);
			updateRows = pst.executeUpdate();
			dbCon.commit();
		} catch (Exception e) {
			try {
				dbCon.rollback(); // 出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataAccess.close(rs, pst, dbCon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateRows;
	}

}
