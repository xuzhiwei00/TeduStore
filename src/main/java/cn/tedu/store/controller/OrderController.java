package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IOrderService;
import jdk.management.cmm.SystemResourcePressureMXBean;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Resource
	private IOrderService orderService;
	@Resource
	private IAddressService addressService;
	@RequestMapping("/showOrder.do")
	public String orderConfirm(HttpSession session,Integer[] ids,ModelMap map){
		List<CartVo> orderList=orderService.getOrderByIds(getId(session), ids);
		System.out.println("orderList"+orderList);
		map.addAttribute("orderList",orderList);
		session.setAttribute("listVo", orderList);
		List<Address> addressList=addressService.getAddressByUid(getId(session));
		map.addAttribute("addressList",addressList);
		return "orderConfirm";
	}
	@RequestMapping("/addOrder.do")
	public String addOrder(HttpSession session){
		Order order=new Order();
		order.setUid(getId(session));
		List<CartVo> listVo=(List<CartVo>) session.getAttribute("listVo");
		System.out.println("listVo"+listVo);
		orderService.addOrder(order, listVo);
		System.out.println("11111111111111111111111111111111111111");
		System.out.println("order"+order.getId());
		session.setAttribute("oid", order.getId());
		return "payment";
	}
	@RequestMapping("/payment.do")
	public String payment(HttpSession session){
		Integer oid=(Integer) session.getAttribute("oid");
		System.out.println("oid="+oid);
		orderService.updateItem(oid);
		return "pay_success";
	}
	
}
