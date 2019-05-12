package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	public IGoodsService goodsService;
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		if(page==null){
			page=1;
		}
		Integer offset=(page-1)*IGoodsService.PER_COUNT;
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(categoryId, offset, IGoodsService.PER_COUNT);
		map.addAttribute("goodsList",goodsList);
		Integer count=goodsService.getCount(categoryId);
		map.addAttribute("count",count);
		Integer pages=count%IGoodsService.PER_COUNT==0?
				count/IGoodsService.PER_COUNT:count/IGoodsService.PER_COUNT+1;
		map.addAttribute("pages", pages);
		map.addAttribute("page", page);
		map.addAttribute("categoryId",categoryId);
		return "search";
	}
	@RequestMapping("/goodsInfo.do")
	public String goodsInfo(Integer id,ModelMap map,Integer categoryId){
		Goods goods=goodsService.getGoodsById(id);
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		map.addAttribute("goods",goods);
		map.addAttribute("goodsList",goodsList);
		return "product_details";
	}
}
