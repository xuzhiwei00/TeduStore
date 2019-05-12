package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	/*
	 * 插入数据到t_cart表（订单表）里面
	 */
	void insertCart(Cart cart);
	/*
	 * 根据uid查询一个人的商品列表
	 */
	List<Cart> selectCartByUId(Integer uid);
	/*
	 * 根据uid查询这个用户的所有订单信息
	 */
	List<CartVo> selectCart(Integer uid);
	/*
	 * 通过id删除购物车里的商品
	 */
	void deleteCartById(Integer id);
	/*
	 * 批量删除
	 */
	void deleteBatchById(Integer[] ids);
	/*
	 * 修改商品数量
	 */
	void updateCountById(@Param("id") Integer id,@Param("count") Integer count);
}
