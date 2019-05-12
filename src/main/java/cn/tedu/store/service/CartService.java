package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		List<Cart> listCart=cartMapper.selectCartByUId(cart.getUid());
		for(Cart cart1:listCart){
			if(cart.getGoodsId().equals(cart1.getGoodsId())){
				Integer count=cart.getCount()+cart1.getCount();
				cart.setCount(count);
				cartMapper.updateCountById(cart1.getId(), count);
				return;
			}
		}
		cartMapper.insertCart(cart);
	}
	public List<CartVo> getCartByUid(Integer uid) {
		List<CartVo> list=cartMapper.selectCart(uid);
		return list;
	}
	public void deleteById(Integer id) {
		cartMapper.deleteCartById(id);
		
	}
	public void deleteBatchById(Integer[] ids) {
		cartMapper.deleteBatchById(ids);
		
	}
	public void updateCountById(Integer id, Integer count) {
		cartMapper.updateCountById(id, count);
		
	}
	
}
