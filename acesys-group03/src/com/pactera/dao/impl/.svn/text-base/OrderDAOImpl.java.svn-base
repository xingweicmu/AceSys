/**
 * 实现系统业务和数据接口
 */
package com.pactera.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pactera.bean.Orderitem;
import com.pactera.bean.Orders;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.OrderDAO;
import com.pactera.util.DataAccess;

/**
 * 实现对订单操作的接口
 * @author 金轶伦
 * @version 1.0
 * create:2013-06-06
 */

public class OrderDAOImpl implements OrderDAO {
	

	public Orders findOrderList(String oid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		
		try {
			conn = DataAccess.getConnection();
			sql="SELECT * FROM orders where oid = ?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, oid);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				
				int oid_1 = rs.getInt("oid");
				int uid = rs.getInt("uid");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				char delsoft = rs.getString("delsoft").charAt(0);
				char status = rs.getString("status").charAt(0);
				
				//----------get user----------//
				User user = new User();
				
				sql="SELECT * FROM usr WHERE uid = ?";					
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(uid, 1);
				ResultSet rs2=pst.executeQuery();
				rs2.next();
				user.setUserID(uid);
				String superuser=rs2.getString("superuser");
				if(superuser.equals("1")){
					user.setRole(UserRole.NORMAL);
				}
				if(superuser.equals("2")){
					user.setRole(UserRole.VIP);
				}
				if(superuser.equals("3")){
					user.setRole(UserRole.MANAGER);
				}
				user.setUserName(rs2.getString("username"));
				user.setDelsoft(rs2.getString("delsoft").charAt(0));
				user.setCompanyName(rs2.getString("companyname"));
				user.setCompanyAddress(rs2.getString("companyaddress"));
				user.setCity(rs2.getString("city"));
				user.setJob(rs2.getString("job"));
				user.setTel(rs2.getString("tel"));
				user.setEmail(rs2.getString("email"));
				user.setZip(rs2.getString("zip"));
				user.setNote(rs2.getString("note"));
				user.setFullName(rs2.getString("fullname"));
				
				
				Orders order=new Orders(oid_1, user, starttime, endtime, delsoft, status);
			
				
				return order;
			
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

	
	
	public List<Orders> findAllOrders() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		ArrayList<Orders> array=new ArrayList<Orders>();
		try {

			
			conn = DataAccess.getConnection();
			sql="SELECT * FROM orders";
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<User> userList = new ArrayList<User>();
			
			while(rs.next()){
				
				int oid_1 = rs.getInt("oid");
				int uid = rs.getInt("uid");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				char delsoft = rs.getString("delsoft").charAt(0);
				char status = rs.getString("status").charAt(0);
				
				User user = null;
				
				boolean flag = false;
				
				for(int i = 0;i<userList.size();i++){
					if(uid==userList.get(i).getUserID()){
						user = userList.get(i);
						flag = true;
						break;
					}
				}
				
				if(!flag){
					user= new User();
					sql="SELECT * FROM usr WHERE uid = "+uid;					
					Statement pst=conn.createStatement();
					ResultSet rs2=pst.executeQuery(sql);
					rs2.next();
					user.setUserID(uid);
					String superuser=rs2.getString("superuser");
					if(superuser.equals("1")){
						user.setRole(UserRole.NORMAL);
					}
					if(superuser.equals("2")){
						user.setRole(UserRole.VIP);
					}
					if(superuser.equals("3")){
						user.setRole(UserRole.MANAGER);
					}
					user.setUserName(rs2.getString("username"));
					user.setDelsoft(rs2.getString("delsoft").charAt(0));
					user.setCompanyName(rs2.getString("companyname"));
					user.setCompanyAddress(rs2.getString("companyaddress"));
					user.setCity(rs2.getString("city"));
					user.setJob(rs2.getString("job"));
					user.setTel(rs2.getString("tel"));
					user.setEmail(rs2.getString("email"));
					user.setZip(rs2.getString("zip"));
					user.setNote(rs2.getString("note"));
					user.setFullName(rs2.getString("fullname"));
					userList.add(user);
				}
				
				Orders order=new Orders(oid_1, user, starttime, endtime, delsoft, status);
				
				array.add(order);
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
		
		return array;
	}

	public List<Orders> findOrdersOfUser(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		ArrayList<Orders> array=new ArrayList<Orders>();
		try {
			
			
			conn = DataAccess.getConnection();
			
			sql="SELECT * FROM usr WHERE uid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			User user = new User();
			
			if(rs.next()){			
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
			
			
			}else{
				return array;
			}
			
			sql="SELECT * FROM orders where uid=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int oid_1 = rs.getInt("oid");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				char delsoft = rs.getString("delsoft").charAt(0);
				char status = rs.getString("status").charAt(0);
				
				
				Orders order=new Orders(oid_1, user, starttime, endtime, delsoft, status);
				
				array.add(order);		
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
		return array;
	}

	public int deleteOrderItem(int oiid) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;	
		
		try {
			
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);
			
			sql="DELETE FROM orderitem WHERE oiid=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, oiid);
			
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

	public int delSoftOrders(int oid, char delsoft) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;	
		
		try {
			
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);
			
			sql="UPDATE orders SET delsoft=? WHERE oid=? "; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(delsoft));
			pstmt.setInt(2, oid);
			
			rs = pstmt.executeUpdate();
			
			conn.commit();
			
			return rs;
			
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
		return 0;
	}

	public int saveOrder(Orders order, ArrayList<Orderitem> orderItems) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;	
		
		try {
			
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);
			
			sql="INSERT INTO orders VALUES (?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, order.getOid());//?????????????????????
			pstmt.setInt(2, order.getUser().getUserID());
			pstmt.setString(3, order.getStarttime());
			pstmt.setString(4, order.getEndtime());
			pstmt.setString(5, String.valueOf(order.getDelsoft()));
			pstmt.setString(6, String.valueOf(order.getStatus()));
			
			rs = pstmt.executeUpdate();
			if(rs==0){
				return rs;
			}
			/////--------------user----------////////////
			User theUser = order.getUser();
			
			String update = "UPDATE usr SET username = ?, password = ?, "
					+ "companyname = ?, city = ?, job = ?, tel = ?, email = ?, "
					+ "country = ?, zip = ?, companyaddress = ?, superuser = ?, "
					+ "note = ?, fullname = ?, delsoft = ? WHERE uid = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, theUser.getUserName());
			pstmt.setString(2, theUser.getPassword());
			pstmt.setString(3, theUser.getCompanyName());
			pstmt.setString(4, theUser.getCity());
			pstmt.setString(5, theUser.getJob());
			pstmt.setString(6, theUser.getTel());
			pstmt.setString(7, theUser.getEmail());
			pstmt.setString(8, theUser.getCountry());
			pstmt.setString(9, theUser.getZip());
			pstmt.setString(10, theUser.getCompanyAddress());
			pstmt.setString(11,
					new Character(theUser.getRole().getRight()).toString());
			pstmt.setString(12, theUser.getNote());
			pstmt.setString(13, theUser.getFullName());
			pstmt.setString(14, new Character(theUser.getDelsoft()).toString());
			pstmt.setInt(15, theUser.getUserID());
			
			rs = pstmt.executeUpdate();
			if(rs==0){
				return rs;
			}
			/////--------------order item----------////////////
			for(int i=0;i<orderItems.size();i++){
				Orderitem orderItem=orderItems.get(i);
				sql = "INSERT INTO orderitem VALUES (?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, orderItem.getOiid());
				pstmt.setInt(2, orderItem.getOrders().getOid());
				pstmt.setInt(3, orderItem.getProduct().getProductID());
				pstmt.setInt(4, orderItem.getQuantity());
				
				rs = pstmt.executeUpdate();
				if(rs==0){
					return rs;
				}
			}
			
			conn.commit();
			
			return 1;
			
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
		
		
		return 0;
	}







}
