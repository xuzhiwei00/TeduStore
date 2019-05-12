package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		List<GoodsCategory> computerList=goodsCategoryService.getGoodsCategoryByParentId(161, 0, 3);
		System.out.println(computerList);
		List<List<GoodsCategory>> category161List=new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory goodsCategory:computerList){
			Integer id=goodsCategory.getId();
			List<GoodsCategory> list=goodsCategoryService.getGoodsCategoryByParentId(id, null, null);
			System.out.println(list);
			category161List.add(list);
		}
		//把两个集合分别设置到map中
		map.addAttribute("computerList",computerList);
		map.addAttribute("category161List", category161List);
		//热门商品的展示
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(163, 0, 3);
		map.addAttribute("goodsList",goodsList);
		return "index";
	}
}
