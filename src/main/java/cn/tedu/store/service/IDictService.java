package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;

public interface IDictService {
	List<Provinces> getProvince();
	List<City> getCity(String provinceCode);
	List<Areas> getAreas(String cityCode);
}
