package cn.tedu.store.bean;

import java.sql.Date;

public class Address {
	private Integer id;
	private Integer uid;
	private String recvName;
	private String recvProvince;
	private String recvCity;
	private String recvArea;
	private String recvDistric;
	private String recvAddress;
	private String recvPhone;
	private String recvTel;
	private String recvZip;
	private String recvTag;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	private Integer isdefault;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(Integer id, Integer uid, String recvName, String recvProvince, String recvCity, String recvArea,
			String recvDistric, String recvAddress, String recvPhone, String recvTel, String recvZip, String recvTag,
			String createdUser, Date createdTime, String modifiedUser, Date modifiedTime, Integer isdefault) {
		super();
		this.id = id;
		this.uid = uid;
		this.recvName = recvName;
		this.recvProvince = recvProvince;
		this.recvCity = recvCity;
		this.recvArea = recvArea;
		this.recvDistric = recvDistric;
		this.recvAddress = recvAddress;
		this.recvPhone = recvPhone;
		this.recvTel = recvTel;
		this.recvZip = recvZip;
		this.recvTag = recvTag;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
		this.isdefault = isdefault;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvProvince() {
		return recvProvince;
	}
	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}
	public String getRecvCity() {
		return recvCity;
	}
	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}
	public String getRecvArea() {
		return recvArea;
	}
	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}
	public String getRecvDistric() {
		return recvDistric;
	}
	public void setRecvDistric(String recvDistric) {
		this.recvDistric = recvDistric;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvTel() {
		return recvTel;
	}
	public void setRecvTel(String recvTel) {
		this.recvTel = recvTel;
	}
	public String getRecvZip() {
		return recvZip;
	}
	public void setRecvZip(String recvZip) {
		this.recvZip = recvZip;
	}
	public String getRecvTag() {
		return recvTag;
	}
	public void setRecvTag(String recvTag) {
		this.recvTag = recvTag;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", recvProvince=" + recvProvince
				+ ", recvCity=" + recvCity + ", recvArea=" + recvArea + ", recvDistric=" + recvDistric
				+ ", recvAddress=" + recvAddress + ", recvPhone=" + recvPhone + ", recvTel=" + recvTel + ", recvZip="
				+ recvZip + ", recvTag=" + recvTag + ", createdUser=" + createdUser + ", createdTime=" + createdTime
				+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + ", isdefault=" + isdefault
				+ "]";
	}
	
	
	
	
}
