package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	/*
	 * 添加收货地址
	 */
	void addAddress(Address address);
	/*
	 * 通过uid查询收货地址
	 */
	List<Address> getAddressByUid(Integer uid);
	/*
	 * 通过id查询
	 */
	void setDefault(Integer uid, Integer id);
	/*
	 * 通过id查询地址
	 */
	Address getAddressById(Integer id);
	/*
	 * 通过id修改地址
	 */
	void updateAddressById(Address address);
	/*
	 * 通过id删除地址
	 */
	void deleteAddressById(Integer id);
}
