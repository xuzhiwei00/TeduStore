package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

public class TestService {
	private IUserService um;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		um=ac.getBean("userService",IUserService.class);
	}
	/*
	 * 测试业务层register方法是否能正常运行
	 */
	@Test
	public void testRegister(){
		User user=new User();
		user.setUsername("slk");
		user.setPassword("sdf123");
		user.setPhone("123544");
		user.setEmail("456@cn.tedu");
		um.register(user);
	}
	/*
	 * 测试业务层邮箱是否存在
	 */
	@Test
	public void testCheckEmail(){
		System.out.println(um.checkEmail("123"));
	}
	/*
	 * 测试业务层电话是否存在
	 */
	@Test
	public void testCheckPhone(){
		System.out.println(um.checkPhone("123"));
	}
	/*
	 * 测试用户名是否存在
	 */
	@Test
	public void testCheckUsername(){
		System.out.println(um.checkUsername("slk"));
	}
	/*
	 * 测试登录页面login方法，用户名密码是否正确
	 */
	@Test
	public void testLogin(){
		User user=um.login("haha", "123");
		System.out.println(user);
	}
}
