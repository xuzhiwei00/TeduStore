package test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;

import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategory {
	private GoodsCategoryMapper gMapper;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		gMapper=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	}
	@Test
	public void selectByParentId(){
		List<GoodsCategory> list=gMapper.selectCategoryByParentId(1100, 5, 5);
		System.out.println(list);
	}
}
