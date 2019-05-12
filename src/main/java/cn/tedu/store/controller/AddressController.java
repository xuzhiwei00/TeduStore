package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	IAddressService addressService;
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		Address address=new Address();
		address.setRecvName(recvName);
		address.setUid(getId(session));
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		rr.setState("1");
		rr.setMessage("填写成功");
		return rr;
	}
	@RequestMapping("/getAddressByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddressByUid(HttpSession session){
		ResponseResult<List<Address>> rr=new ResponseResult<List<Address>>();
		Integer uid=getId(session);
		List<Address> list=addressService.getAddressByUid(uid);
		rr.setDate(list);
		return rr;
	}
	@RequestMapping("/getDefault.do")
	@ResponseBody
	public ResponseResult<Void> getDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		try {
			addressService.setDefault(getId(session),id);
			rr.setState("1");
			rr.setMessage("设置成功");
		} catch (Exception e) {
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public ResponseResult<Address> getAddressById(Integer id){
		ResponseResult<Address> rr=new ResponseResult<Address>();
		Address address=addressService.getAddressById(id);
		rr.setDate(address);
		return rr;
	}
	@RequestMapping("/updateAddressById.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		Address address=new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddressById(address);
		rr.setState("1");
		rr.setMessage("修改成功");
		return rr;
	}
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddress(Integer id){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		addressService.deleteAddressById(id);
		rr.setState("1");
		rr.setMessage("删除成功");
		return rr;
		
	}
}
