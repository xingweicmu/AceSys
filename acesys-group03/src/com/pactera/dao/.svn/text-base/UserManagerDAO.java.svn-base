/**
 * 描述系统业务接口和数据接口
 */
package com.pactera.dao;

import java.util.List;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;

/**
 * 管理员对用户操作接口
 * @author David.Wei
 * @version 1.0
 * created: 2013-06-06
 */
public interface UserManagerDAO {

	/**
	 * 系统管理员增加用户
	 * @param newUser 新用户
	 * @return 是否成功添加用户 1:成功添加 0：添加失败
	 */
	int addProductUser(User newUser);
	
	/**
	 * 系统管理员查询全部系统用户对象
	 * @return 所有用户数组列表
	 */
	List<User> findAllProductUsr();
	
	/**
	 * 系统管理员通过用户主键id获取用户对象
	 * @param uid 用户主键Id
	 * @return 查询到的用户对象
	 */
	User findUserById(int uid);
	
	/**
	 * 系统管理员通过用户名获取用户对象（相等查询）
	 * @param username 用户名
	 * @return 查询到的用户对象
	 */
	User findUserByUsername(String username);
	
	/**
	 * 注册功能，判断用户名是否存在
	 * @param username 用户名
	 * @return 用户名是否存在 
	 */
	boolean opName(String username);
	
	/**
	 * 系统管理员更新用户信息
	 * @param theUser 被更新的用户对象
	 * @return 是否更新成功 1：更新成功 0：更新用户信息失败
	 */
	int updateUser(User theUser);
	
	/**
	 * 系统管理员更新用户角色
	 * @param uid 用户标识号
	 * @param theRole 用户角色对象
	 * @return 是否更新角色成功  1：更新成功 0：更新用户信息失败
	 */
	int updateUserRole(int uid, UserRole theRole);
	
	/**
	 * 软删除用户
	 * @param uid 用户标识号
	 * @param delSoft 软删除标识
	 * @return 是否软删除成功 1：软删除成功 0：软删除失败
	 */
	int delSoftUser(int uid, char delSoft);
	
	/**
	 * 修改用户密码
	 * @param uid 用户标识符
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 */
	int updatePassword(int uid, String oldPassword, String newPassword);
}
