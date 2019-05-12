package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/*
	 * 向数据库插入地址
	 */
	void insert(Address address);
	/*
	 * 通过uid查询地址,一个人的收货地址可以是多个，所以用集合来接收
	 * 如果存在收货地址list.size()>0
	 * 如果收货地址不存在，list集合size()==0
	 */
	List<Address> selectAddressByUid(Integer uid);
	/*
	 * 把登录用户的所有isdefault=0
	 */
	Integer setCancel(Integer uid);
	/*
	 * 把选中isdefault=1
	 */
	Integer setDefault(Integer id);
	/*
	 * 通过id查询地址
	 */
	Address selectAddressById(Integer id);
	/*
	 * 通过id修改地址
	 */
	void updateById(Address address);
	/*
	 * 删除地址
	 */
	void deleteById(Integer id);
}
