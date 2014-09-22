/**
 * 实现系统业务和数据接口
 */
package com.pactera.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.loginDAO;
import com.pactera.util.DataAccess;

/**
 * 实现登陆操作接口
 * @author 金轶伦
 * @version 1.0
 * create:2013-06-08
 */

public class LoginDAOImpl implements loginDAO {

	public User login(String username, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DataAccess.getConnection();
			
			sql="SELECT * FROM usr WHERE username=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				User user = new User();
				String superuser=rs.getString("superuser");
				if(superuser.equals("1")){
					user.setRole(UserRole.NORMAL);
				}
				if(superuser.equals("2")){
					user.setRole(UserRole.VIP);
				}
				if(superuser.equals("3")){
					user.setRole(UserRole.MANAGER);
				}
				user.setUserID(rs.getInt("uid"));
				user.setUserName(rs.getString("username"));
				user.setDelsoft(rs.getString("delsoft").charAt(0));
				user.setCompanyName(rs.getString("companyname"));
				user.setCompanyAddress(rs.getString("companyaddress"));
				user.setCity(rs.getString("city"));
				user.setJob(rs.getString("job"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setZip(rs.getString("zip"));
				user.setNote(rs.getString("note"));
				user.setFullName(rs.getString("fullname"));
				
				
				return user;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				DataAccess.close(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
