package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;

public interface DictMapper {
	/*
	 * 查询省份
	 */
	List<Provinces> selectProvince();
	/*
	 * 查询城市
	 */
	List<City> selectCity(String provinceCode);
	/*
	 * 查询区/县
	 */
	List<Areas> selectAreas(String cityCode);
	/*
	 * 通过省份的code查询省份的名字
	 */
	String selectProvinceNameByCode(String provinceCode);
	/*
	 * 通过城市的code查询城市的名字
	 * 
	 */
	String selectCityNameByCode(String cityCode);
	/*
	 * 通过区的code查询区的名字
	 */
	String selectAreasNameByCode(String AreaCode);
}
