package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;
import cn.tedu.store.mapper.DictMapper;

@Service
public class DictService implements IDictService{
	@Resource
	DictMapper dictMapper;
	public List<Provinces> getProvince() {
		return dictMapper.selectProvince();
	}
	public List<City> getCity(String provinceCode){
		return dictMapper.selectCity(provinceCode);
	}
	public List<Areas> getAreas(String cityCode){
		return dictMapper.selectAreas(cityCode);
	}
	
	
}
