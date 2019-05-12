package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrderMapper;
@Service
public class OrderService implements IOrderService{
	@Resource
	private CartMapper cartMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private GoodsMapper goodsMapper;

	public List<CartVo> getOrderByIds(Integer uid, Integer[] ids) {
		List<CartVo> orderList=new ArrayList<CartVo>();
		System.out.println(uid);
		List<CartVo> list=cartMapper.selectCart(uid);
		System.out.println("list"+list);
		for(CartVo cart:list){
			for(Integer id:ids){
				if(cart.getId()==id){
					orderList.add(cart);
					break;
				}
			}
		}
		return orderList;
	}

	public void addOrder(Order order, List<CartVo> listVo) {
		orderMapper.insertOrder(order);
		for(CartVo cart:listVo){
			System.out.println(cart.getGoodsId());
			OrderItem orderItem=new OrderItem();
			orderItem.setUid(cart.getUid());
			orderItem.setGoodsId(cart.getGoodsId());
			orderItem.setImage(cart.getImage());
			orderItem.setPrice(cart.getPrice());
			orderItem.setCount(cart.getCount());
			orderItem.setPaymentstatus(0);
			orderItem.setOrderstatus(0);
			orderItem.setOrderId(cart.getId());
			orderMapper.insertOrderItem(orderItem);
			//根据Id查询商品信息
			Goods goods=goodsMapper.selectByGoodsId(Integer.parseInt(cart.getGoodsId()));
			System.out.println(goods);
			//修改库存
			goodsMapper.updateNumById(Integer.parseInt(cart.getGoodsId()), goods.getNum()-cart.getCount());
			
		}
		
	}

	public void updateItem(Integer orderId) {
		orderMapper.updatePaymentStatusByOrderId(orderId);
		
	}
	
}
