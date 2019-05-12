package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	Integer PER_COUNT=12;
	List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);
	/*
	 * 获取商品数量，以便显示页数
	 */
	Integer getCount(Integer categoryId);
	/*
	 * 获取商品详情，通过商品id
	 */
	Goods getGoodsById(Integer id);
}
