/**
 * ������ݷ�װ��
 */
package com.pactera.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �û��࣬�����û��Ļ�����Ϣ
 * 
 * @author Brandon
 * @version 1.0 
 * created: 2013-06-06
 */
public class User implements Serializable {

	private int userID; // �û���ʶ��
	private String userName; // �û���
	private String password; // ����
	private String companyName; // ��˾��
	private String city; // ���ڳ���
	private String job; // ����
	private String tel; // �绰
	private String email; // ����
	private String zip; // �ʱ�
	private String country; // ����
	private UserRole role; // �û�Ȩ��
	private String companyAddress; // ��˾��ַ
	private String fullName; // ȫ��
	private String note; // ��ע
	private char delsoft = '0';  // ��ɾ��ֵ
	
	/**
	 * Ĭ�Ϲ��캯��
	 */
	public User() {
		super();
	}
	
	/**
	 * �����û���������ͽ�ɫ���췽��
	 * @param uid �û���ʶ��
	 * @param userName �û���
	 * @param password ����
	 * @param role �û�Ȩ��
	 */
	public User(int uid, String userName, String password, UserRole role) {
		super();
		this.userID = uid;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	
	/**
	 * ������ϸ�û���Ϣ�Ĺ������
	 * @param userID �û���ʶ��
	 * @param userName �û���
	 * @param password ����
	 * @param companyName ��˾��
	 * @param city ����
	 * @param job ����
	 * @param tel �绰
	 * @param email ����
	 * @param zip �ʱ�
	 * @param country ����
	 * @param role �û�Ȩ��
	 * @param companyAddress ��˾��ַ
	 * @param fullName ȫ��
	 * @param note ��ע
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
	 * �����û���ʶ��
	 * 
	 * @return �û���ʶ��
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * �����û���ʶ��
	 * 
	 * @param userID �û��±�ʶ��
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * �����û���
	 * @return �û���
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �����û���
	 * @param userName ���û��� 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �����û�����
	 * @return �û�����
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * �����û�����
	 * @param password ������
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ���ع�˾��
	 * @return ��˾��
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * ���ù�˾��
	 * @param companyName �¹�˾��
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * ���س�����
	 * @return ������
	 */
	public String getCity() {
		return city;
	}

	/**
	 * ������������
	 * @param city ����������
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * ���ع�����Ϣ
	 * @return ������Ϣ
	 */
	public String getJob() {
		return job;
	}

	/**
	 * ���ù�����Ϣ
	 * @param job �¹�����Ϣ
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * ���ص绰����
	 * @return �绰����
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * ���õ绰����
	 * @param tel �µ绰����
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * ��������
	 * @return ����
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ��������
	 * @param email ������
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * �����ʱ�
	 * @return �ʱ�
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * �����ʱ�
	 * @param zip ���ʱ�
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * ���ع���
	 * @return ����
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * ���ù���
	 * @param country �¹���
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * �����û�Ȩ��
	 * @return �û�Ȩ��
	 */
	public UserRole getRole() {
		return role;
	}

	/**
	 * �����û�Ȩ��
	 * @param role ���û�Ȩ��
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}

	/**
	 * ���ع�˾��ַ
	 * @return ��˾��ַ
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * ���ù�˾��ַ
	 * @param companyAddress �¹�˾��ַ
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * �����û�ȫ��
	 * @return �û�ȫ��
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * �����û�ȫ��
	 * @param fullName �û�ȫ��
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * ���ر�ע
	 * @return ��ע
	 */
	public String getNote() {
		return note;
	}

	/**
	 * ���ñ�ע
	 * @param note �±�ע��Ϣ
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * ������ɾ��ֵ
	 * @return ��ɾ��ֵ
	 */
	public char getDelsoft() {
		return delsoft;
	}

	/**
	 * ������ɾ��ֵ��0Ϊ������1Ϊ��ɾ��
	 * @param delsoft ����ɾ��ֵ
	 */
	public void setDelsoft(char delsoft) {
		this.delsoft = delsoft;
	}
	
}
