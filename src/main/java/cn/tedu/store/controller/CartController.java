package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		Integer uid=getId(session);
		List<CartVo> cartVoList=cartService.getCartByUid(uid);
		map.addAttribute("cartVoList",cartVoList);
		return "cart";
	}
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,
			 Integer num){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		Cart cart=new Cart();
		cart.setUid(getId(session));
		
		cart.setCount(num);
		cart.setGoodsId(goodsId);
		System.out.println(num);
		cartService.addCart(cart);
		rr.setState("1");
		rr.setMessage("添加成功");
		return rr;
	}
	@RequestMapping("/deleteByCartId.do")
	public String deleteById(Integer id){
		cartService.deleteById(id);
		return "redirect:showCart.do";
	}
	@RequestMapping("/deleteByBatch.do")
	public String deleteBatchById(Integer[] ids){
		cartService.deleteBatchById(ids);
		return "redirect:showCart.do";
	}
	@RequestMapping("/updateNumById.do")
	@ResponseBody
	public ResponseResult<Void> updateCountById(Integer id,Integer num){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		cartService.updateCountById(id, num);
		rr.setState("1");
		rr.setMessage("修改成功");
		return rr;
	}
}