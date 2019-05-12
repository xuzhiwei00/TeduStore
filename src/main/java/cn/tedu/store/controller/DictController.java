package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IDictService dictService;
	/*
	 * 将数据库查询的省份结果设置到rr对象中上返回
	 */
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Provinces>> showProvince(){
		ResponseResult<List<Provinces>> rr=new ResponseResult<List<Provinces>>();
		rr.setDate(dictService.getProvince());
		return rr;
	}
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		rr.setDate(dictService.getCity(provinceCode));
		return rr;
	}
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Areas>> showAreas(String cityCode){
		ResponseResult<List<Areas>> rr=new ResponseResult<List<Areas>>();
		rr.setDate(dictService.getAreas(cityCode));
		return rr;
	}
}
