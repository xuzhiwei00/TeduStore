package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;
import cn.tedu.store.service.IDictService;

public class TestDictService {
	private IDictService ds;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ds=ac.getBean("dictService",IDictService.class);
	}
	/*
	 * 测试getProvince方法
	 */
	@Test
	public void testGetProvince(){
		List<Provinces> provinces=ds.getProvince();
		System.out.println(provinces);
	}
	/*
	 * 测试getCity方法
	 */
	@Test
	public void testGetCity(){
		List<City> city=ds.getCity("130000");
		System.out.println(city);
	}
	/*
	 * 测试getAreas方法
	 */
	@Test
	public void testGetAreas(){
		List<Areas> areas=ds.getAreas("130100");
		System.out.println(areas);
	}
}
