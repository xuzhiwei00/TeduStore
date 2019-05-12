package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 注册功能的方法
	 */
	void register(User user);
	/*
	 * 验证邮箱是否存在，如果存在返回true，否则返回false
	 */
	boolean checkEmail(String email);
	/*
	 * 验证电话是否存在，如果存在返回true，否则返回false
	 */
	boolean checkPhone(String phone);
	/*
	 * 验证用户名是否存在，如果存在返回true，否则返回false
	 */
	boolean checkUsername(String username);
	/*
	 * 验证登录页面用户名密码是否正确
	 */
	User login(String username,String password);
	/*
	 * 修改密码
	 */
	boolean changePassword(Integer id, String oldPassword, String newPassword);
	/*
	 * 修改个人信息
	 */
	void updateUser(Integer id,String username,String password,String email,String phone,Integer gender);
	/*
	 * 通过id查询获取User对象
	 */
	User getSelectById(Integer id);
	/*
	 * 通过id修改image
	 */
	void updateImageById(String image, Integer id);
}
