package test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;


public class TestUser {
	private UserMapper userMapper;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		userMapper=ac.getBean("userMapper",UserMapper.class);
	}
	@Test
	public void testInsert(){
		User user=new User();
		user.setUsername("slkjk");
		user.setPassword("sdf123");
		user.setPhone("123544");
		user.setEmail("456@cn.tedu");
		userMapper.insert(user);
	}
	@Test
	public void testSelectByUname(){
		User user=userMapper.selectByUsername("slkjk");
		System.out.println(user);
		
	}
	//测试邮箱在数据库中是否存在
	@Test
	public void testSelectByEmail(){
		int math=userMapper.selectByEmail("123@cn.tedu");
		System.out.println(math);
	}
	//测试电话在数据库中是否存在
	@Test
	public void testSelectByPhone(){
		int math=userMapper.selectByPhone("123");
		System.out.println(math);
	}
	@Test
	public void testSelectById(){
		User user=userMapper.selectById(1);
		System.out.println(user);
	}
	@Test
	public void testUpdate(){
		User user=userMapper.selectById(1);
		user.setPassword("111111");
		userMapper.update(user);
		User user2=userMapper.selectById(1);
		System.out.println(user2);
	}
}
