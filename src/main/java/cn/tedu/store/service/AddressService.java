package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;

	public void addAddress(Address address) {
		String provinceName=dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String cityName=dictMapper.selectCityNameByCode(address.getRecvCity());
		String areaName=dictMapper.selectAreasNameByCode(address.getRecvArea());
		address.setRecvDistric(provinceName+cityName+areaName);
		List<Address> list=addressMapper.selectAddressByUid(address.getUid());
		if(list.size()>0){
			//isdefault是默认地址的意思
			address.setIsdefault(0);
		}else if(list.size()==0){
			address.setIsdefault(1);
		}
		addressMapper.insert(address);
	}
	public List<Address>getAddressByUid(Integer uid){
		List<Address> list=addressMapper.selectAddressByUid(uid);
		return list;
	}
	public void setDefault(Integer uid, Integer id) {
		//将这个用户下的所有地址的isdefault都改为0
		Integer a = addressMapper.setCancel(uid);
		if(a==0){
			//如果a=0则说明一条都没改
			throw new RuntimeException("修改数据失败");
		}
		//通过id找到用户点击的这个地址，将isdefault改为1
		Integer b = addressMapper.setDefault(id);
		if(b==0){
			//如果b=0则说明一条数据都没修改
			throw new RuntimeException("修改数据失败");
		}
		
	}
	public Address getAddressById(Integer id) {
		Address address=addressMapper.selectAddressById(id);
		return address;
	}
	public void updateAddressById(Address address) {
		address.setRecvDistric(dictMapper.selectProvinceNameByCode(address.getRecvProvince())+
				dictMapper.selectCityNameByCode(address.getRecvCity())+
				dictMapper.selectAreasNameByCode(address.getRecvArea()));
		addressMapper.updateById(address);
	}
	public void deleteAddressById(Integer id) {
		addressMapper.deleteById(id);
		
	}
	
}
