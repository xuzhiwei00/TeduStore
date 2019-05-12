package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;
import cn.tedu.store.mapper.DictMapper;

public class TestProvince {
	private DictMapper dictMapper;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		dictMapper=ac.getBean("dictMapper",DictMapper.class);
	}
	@Test
	public void selectProvince(){
		List<Provinces> provinces=dictMapper.selectProvince();
		System.out.println(provinces);
	}
	@Test
	public void selectCity(){
		List<City> city=dictMapper.selectCity("130000");
		System.out.println(city);
	}
	@Test
	public void selectAreas(){
		List<Areas> areas=dictMapper.selectAreas("130100");
		System.out.println(areas);
	}
	@Test
	public void selectPNameByCode(){
		String pn=dictMapper.selectProvinceNameByCode("130000");
		System.out.println(pn);
	}
	@Test
	public void selectCNameByCode(){
		String city=dictMapper.selectCityNameByCode("130100");
		System.out.println(city);
	}
	@Test
	public void selectANameByCode(){
		String area=dictMapper.selectAreasNameByCode("130130");
		System.out.println(area);
	}
}
