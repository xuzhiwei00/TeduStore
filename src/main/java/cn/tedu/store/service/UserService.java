package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ImageErrorException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;
import cn.tedu.store.service.ex.UserNotFoundExsitException;
@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	public void register(User user) {
		//判断用户名是否存在，如果存在，抛出异常，否则，实现插入操作
		if(userMapper.selectByUsername(user.getUsername())==null){
			userMapper.insert(user);
		}else{
			throw new UserNameAlreadyExsitException("该用户名已经存在");
		}
		System.out.println("nihao");
	}
	public boolean checkEmail(String email){
		/*
		 * 如果邮箱存在，返回true，否则返回false
		 */
		return userMapper.selectByEmail(email)>0;
			
	}
	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)>0;
	}
	public boolean checkUsername(String username) {
		if(userMapper.selectByUsername(username)==null){
			return false;
		}else{
			return true;
		}
	}
	public User login(String username, String password) {
		User user=userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundExsitException("该用户不存在");
		}else{
			if(password.equals(user.getPassword())){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}
	public boolean changePassword(Integer id,String oldpwd,String newpwd){
		User user=userMapper.selectById(id);
		if(user!=null){
			if(user.getPassword().equals(oldpwd)){
				User user2=new User();
				user2.setPassword(newpwd);
				user2.setId(id);
				userMapper.update(user2);
				return true;
			}else{
				throw new PasswordNotMatchException("密码不匹配");
			}
		}else{
			throw new UserNotFoundExsitException("用户名没找到");
		}
		
	}
	public void updateUser(Integer id, String username, String password, String email, String phone, Integer gender) {
		User user=new User();
		User user2=userMapper.selectByUsername(username);
		//用户名在数据库是没有注册过的
		if(user2==null){
			user.setUsername(username);
		//用户名在数据库已经注册过的,以下代码都是在数据库注册过的用户
		}else{
			//判断用户是否为正在登录的用户
			User user3=userMapper.selectById(id);
			if(user3!=null){
				
				if(user3.getUsername().equals(username)){
					
				}else{
					throw new UserNameAlreadyExsitException("用户名已存在");
				}
			}
		}
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.update(user);
	}
	public User getSelectById(Integer id){
		return userMapper.selectById(id);
	}
	public void updateImageById(String image,Integer id){
		try {
			User user=getSelectById(id);
			user.setImage(image);
			userMapper.update(user);
		} catch (Exception e) {
			throw new ImageErrorException("图片上传失败");
		}
		
	}
}
