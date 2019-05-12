package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;

public interface IOrderService {
	List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
	void addOrder(Order order,List<CartVo> listVo);
	void updateItem(Integer orderId);
}
