package test;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrderMapper;

public class TestOrder {
	private OrderMapper orderMapper;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		orderMapper=ac.getBean("orderMapper",OrderMapper.class);
	}
	@Test
	public void insetOrder(){
		Order order=new Order();
		order.setUid(12);
		orderMapper.insertOrder(order);
		
	}
	@Test
	public void insertOrderItem(){
		OrderItem orderItem=new OrderItem();
		orderItem.setUid(12);
		orderItem.setCount(1);
		orderItem.setGoodsId("12");
		orderItem.setImage("110");
		orderItem.setPrice(12000);
		orderMapper.insertOrderItem(orderItem);
	}
	@Test
	public void updatePaymentstatus(){
		orderMapper.updatePaymentStatusByOrderId(22);
	}
}
