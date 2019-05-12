package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/*
	 * 通過categoryId
	 * 查詢商品
	 * 分頁
	 * limit offset，count
	 */
	List<Goods> select(@Param("categoryId") Integer id,@Param("offset") Integer offset,@Param("count") Integer count);
	/*
	 * 查詢商品數量
	 */
	Integer selectCount(Integer categoryId);
	/*
	 * 通过商品id查询商品详情
	 */
	Goods selectByGoodsId(Integer id);
	/*
	 * 在商城中购买商品后，商品表中的数据要做修改
	 */
	void updateNumById(@Param("id") Integer id,@Param("num") Integer num);
}
