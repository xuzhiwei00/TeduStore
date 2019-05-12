package test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;

public class TestCart {
	private CartMapper cartMapper;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		cartMapper=ac.getBean("cartMapper",CartMapper.class);
	}
	@Test
	public void testInsertCart(){
		Cart cart=new Cart();
		cart.setUid(5);
		cart.setGoodsId("132");
		cart.setCount(3);
		cartMapper.insertCart(cart);
	}
	@Test
	public void testSelectCart(){
		List<CartVo> list=cartMapper.selectCart(5);
		System.out.println(list);
	}
	@Test
	public void testDeleteById(){
		cartMapper.deleteCartById(1);
	}
	@Test
	public void testDeleteBatchById(){
		Integer[] ids={47,44};
		cartMapper.deleteBatchById(ids);
	}
	@Test
	public void testUpdateCount(){
		cartMapper.updateCountById(16, 2);
	}
	@Test
	public void testSelectCartByUid(){
		List<Cart> list=cartMapper.selectCartByUId(5);
		System.out.println(list);
	}
}
