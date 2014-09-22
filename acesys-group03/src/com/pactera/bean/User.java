/**
 * 存放数据封装类
 */
package com.pactera.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用户类，包含用户的基本信息
 * 
 * @author Brandon
 * @version 1.0 
 * created: 2013-06-06
 */
public class User implements Serializable {

	private int userID; // 用户标识码
	private String userName; // 用户名
	private String password; // 密码
	private String companyName; // 公司名
	private String city; // 所在城市
	private String job; // 工作
	private String tel; // 电话
	private String email; // 邮箱
	private String zip; // 邮编
	private String country; // 国籍
	private UserRole role; // 用户权限
	private String companyAddress; // 公司地址
	private String fullName; // 全名
	private String note; // 备注
	private char delsoft = '0';  // 软删除值
	
	/**
	 * 默认构造函数
	 */
	public User() {
		super();
	}
	
	/**
	 * 给定用户名，密码和角色构造方法
	 * @param uid 用户标识符
	 * @param userName 用户名
	 * @param password 密码
	 * @param role 用户权限
	 */
	public User(int uid, String userName, String password, UserRole role) {
		super();
		this.userID = uid;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	
	/**
	 * 设置详细用户信息的构造参数
	 * @param userID 用户标识符
	 * @param userName 用户名
	 * @param password 密码
	 * @param companyName 公司名
	 * @param city 城市
	 * @param job 工作
	 * @param tel 电话
	 * @param email 邮箱
	 * @param zip 邮编
	 * @param country 国家
	 * @param role 用户权限
	 * @param companyAddress 公司地址
	 * @param fullName 全名
	 * @param note 备注
	 */
	public User(int userID, String userName, String password,
			String companyName, String city, String job, String tel,
			String email, String zip, String country, UserRole role,
			String companyAddress, String fullName, String note) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.companyName = companyName;
		this.city = city;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.zip = zip;
		this.country = country;
		this.role = role;
		this.companyAddress = companyAddress;
		this.fullName = fullName;
		this.note = note;
	}

	/**
	 * 返回用户标识码
	 * 
	 * @return 用户标识码
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * 设置用户标识码
	 * 
	 * @param userID 用户新标识码
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * 返回用户名
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 * @param userName 新用户名 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 返回用户密码
	 * @return 用户密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 * @param password 新密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 返回公司名
	 * @return 公司名
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置公司名
	 * @param companyName 新公司名
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 返回城市名
	 * @return 城市名
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置所属城市
	 * @param city 所属城市名
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 返回工作信息
	 * @return 工作信息
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 设置工作信息
	 * @param job 新工作信息
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * 返回电话号码
	 * @return 电话号码
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置电话号码
	 * @param tel 新电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 返回邮箱
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 * @param email 新邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 返回邮编
	 * @return 邮编
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * 设置邮编
	 * @param zip 新邮编
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * 返回国籍
	 * @return 国籍
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置国籍
	 * @param country 新国籍
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 返回用户权限
	 * @return 用户权限
	 */
	public UserRole getRole() {
		return role;
	}

	/**
	 * 设置用户权限
	 * @param role 新用户权限
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}

	/**
	 * 返回公司地址
	 * @return 公司地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * 设置公司地址
	 * @param companyAddress 新公司地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 设置用户全名
	 * @return 用户全名
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 设置用户全名
	 * @param fullName 用户全名
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * 返回备注
	 * @return 备注
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 设置备注
	 * @param note 新备注信息
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * 返回软删除值
	 * @return 软删除值
	 */
	public char getDelsoft() {
		return delsoft;
	}

	/**
	 * 设置软删除值，0为正常，1为已删除
	 * @param delsoft 新软删除值
	 */
	public void setDelsoft(char delsoft) {
		this.delsoft = delsoft;
	}
	
}
