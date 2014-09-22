/**
 * 实现系统业务和数据接口
 */
package com.pactera.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pactera.bean.Mailtb;
import com.pactera.dao.MailDAO;
import com.pactera.util.DataAccess;

/**
 * 实现对邮件操作的接口
 * @author 金轶伦
 * @version 1.0
 * create:2013-06-08
 */

public class MailDAOImpl implements MailDAO {

	public Mailtb findMail() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		
		try {
			conn = DataAccess.getConnection();
			sql="SELECT * FROM mailtb";
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				int mid = rs.getInt("mid");
				String fromaddress = rs.getString("fromaddress");
				String frompassword = rs.getString("frompassword");
				String toaddress = rs.getString("toaddress");
			
				Mailtb mailtb=new Mailtb(mid, fromaddress, frompassword, toaddress);
				
				return mailtb;
			
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

	public int saveMail(Mailtb theMail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;	
		
		try {
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);
			
			sql="UPDATE mailtb SET fromaddress=?, frompassword=?, toaddress=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, theMail.getFromaddress());
			pstmt.setString(2, theMail.getFrompassword());
			pstmt.setString(3, theMail.getToaddress());
			
			rs = pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				DataAccess.close(pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

//	public int deleteMail(Mailtb theMail) {
//		return 0;
//	}
//
//	public int sendMail(Mailtb theMail) {
//		return 0;
//	}

}
