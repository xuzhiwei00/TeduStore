package cn.tedu.store.mapper;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;

public interface OrderMapper {
	void insertOrder(Order order);
	void insertOrderItem(OrderItem orderItem);
	void updatePaymentStatusByOrderId(Integer orderId);
}
