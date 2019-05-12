package test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;

import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;

public class TestGoods {
	private GoodsMapper gMapper;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		gMapper=ac.getBean("goodsMapper",GoodsMapper.class);
	}
	@Test
	public void selectByCategoryId(){
		List<Goods> list=gMapper.select(917, 0, 3);
		System.out.println(list);
	}
	@Test
	public void selectCount(){
		Integer num=gMapper.selectCount(163);
		System.out.println(num);
	}
	@Test
	public void selectGoodsById(){
		Goods goods=gMapper.selectByGoodsId(1);
		System.out.println(goods);
	}
}
