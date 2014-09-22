/**
 * 描述系统业务接口和数据接口
 */ 
package com.pactera.dao;

import com.pactera.bean.Mailtb;

/**
 * 对邮件操作的接口
 * @author David.Wei
 * @version 1.0
 * created: 2013-06-06
 */
public interface MailDAO {

	/**
	 * 查询邮件  
	 * @return Mailtb 邮件对象
	 */
	Mailtb findMail();
	
	/**
	 * 保存更新邮件
	 * @param theMail 邮件对象
	 * @return 是否成功保存 1：成功保存 0：保存失败
	 */
	int saveMail(Mailtb theMail);
	
//	/**
//	 * 删除邮件
//	 * @param theMail 邮件对象
//	 * @return 是否成功删除 1：成功删除 0：删除失败
//	 */
//	int deleteMail(Mailtb theMail);
//	
//	/**
//	 * 发送邮件
//	 * @param theMail 即将被发送的邮件对象
//	 * @return 是否成功发送邮件 1：成功发送邮件 0：发送邮件失败
//	 */
//	int sendMail(Mailtb theMail);
}
