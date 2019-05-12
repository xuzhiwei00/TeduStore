package cn.tedu.store.mapper;
/**
 * 对用户管理模块的持久层完成数据库的操作
 */
import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 
	 * 向数据库插入数据
	 */
	void insert(User user);
	User selectByUsername(String username);
	/*
	 * 通过email查询
	 * 如果email存在返回大于0的数，不存在则返回0
	 */
	Integer selectByEmail(String email);
	/*
	 * 通过phone查询
	 * 如果电话存在，返回大于0的数，不存在则返回0
	 */
	Integer selectByPhone(String phone);
	/*
	 * 修改用户信息
	 */
	void update(User user);
	/*
	 * 通过id查找用户信息
	 */
	User selectById(Integer id);
}
