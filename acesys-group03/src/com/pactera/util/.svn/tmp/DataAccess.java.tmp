/**
 * 
 */
package com.pactera.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 数据库工具类，用于获取和关闭数据库连接
 * 
 * @author Brandon
 * @version 1.0
 * created: 2013-06-08
 */
public abstract class DataAccess {
	
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String PROPERTIES_NAME = "/connection.properties";
	private static final String URL_KEY = "url";
	
	/**
	 * 通过JDBC方式获取数据库连接
	 * @return 数据库连接
	 * @throws SQLException 数据库连接异常
	 * @throws IOException 读取properties文件异常
	 * @throws ClassNotFoundException 未发现JDBC驱动异常
	 */
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
		//TODO sdkljfldsjkf
		Class.forName(DRIVERNAME);
		Properties properties = new Properties();  // 定义一个properties
		properties.load(DataAccess.class.getResourceAsStream(PROPERTIES_NAME));  // 让properties对象读取已定义好的文件
		return DriverManager.getConnection(properties.getProperty(URL_KEY), properties);
	}
	
	/**
	 * 通過数据源方式连接数据库连接池获取连接
	 * @param jndi 服务器定义的数据库名称
	 * @return 数据库连接
	 * @throws NamingException 数据源名称未注册异常
	 * @throws SQLException 数据库连接异常
	 */
	public static Connection getConnection(String jndi) throws NamingException, SQLException {
		
		Connection connection = null;  // 定义一个连接
		
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + jndi);  // 查找数据源
		connection = ds.getConnection();   // 获取连接
		return connection;
	}
	
	/**
	 * 关闭数据库结果集，指令以及数据库连接
	 * @param rs 需关闭的结果集
	 * @param st 需关闭的指令
	 * @param con 需关闭的数据库连接
	 * @throws SQLException 数据库关闭异常
	 */
	public static void close(ResultSet rs, Statement st, Connection con) throws SQLException {
		
		if(rs != null) {
			rs.close();
		}
		if(st != null)  {
			st.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	/**
	 * 关闭数据库结果集，指令以及数据库连接
	 * @param st 需关闭的指令
	 * @param con 需关闭的数据库连接
	 * @throws SQLException 数据库关闭异常
	 */
	public static void close(Statement st, Connection con) throws SQLException {
		
		if(st != null) {
			st.close();
		}
		if(con != null) {
			con.close();
		}
	}
}
