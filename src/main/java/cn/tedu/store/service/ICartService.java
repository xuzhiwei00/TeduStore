package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface ICartService {
	/*
	 * 添加订单
	 */
	void addCart(Cart cart);
	/*
	 * 查询一个人的所有订单
	 */
	List<CartVo> getCartByUid(Integer uid);
	/*
	 * 删除商品订单
	 */
	void deleteById(Integer id);
	/*
	 * 通过id批量删除
	 */
	void deleteBatchById(Integer[] ids);
	/*
	 * 通过id修改商品数量
	 */
	void updateCountById(Integer id,Integer count);
}
