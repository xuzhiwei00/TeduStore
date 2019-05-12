package test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Areas;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Provinces;
import cn.tedu.store.mapper.AddressMapper;

public class TestAddress {
	private AddressMapper add;
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		add=ac.getBean("addressMapper",AddressMapper.class);
	}
	@Test
	public void insert(){
		Address address=new Address();
		address.setUid(1);
		address.setRecvName("你麻痹");
		address.setRecvPhone("18291406532");
		address.setRecvProvince("陕西省");
		address.setRecvCity("西安市");
		address.setRecvArea("新城区");
		address.setRecvAddress("百禾家园");
		address.setIsdefault(2);
		address.setRecvDistric("王八");
		add.insert(address);
	}
	@Test
	public void select(){
		List<Address> address=add.selectAddressByUid(5);
		System.out.println(address);
	}
	@Test
	public void setCancel(){
		Integer num=add.setCancel(5);
		System.out.println(num);
	}
	@Test
	public void setDefault(){
		Integer num=add.setDefault(5);
		System.out.println(num);
	}
	@Test
	public void selectAddressById(){
		Address address=add.selectAddressById(1);
		System.out.println(address);
	}
	@Test
	public void updateById(){
		Address address=add.selectAddressById(1);
		address.setId(3);
		add.updateById(address);
	}
	@Test 
	public void deleteById(){
		add.deleteById(1);
	}
}
