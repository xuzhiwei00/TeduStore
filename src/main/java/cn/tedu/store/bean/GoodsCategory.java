package cn.tedu.store.bean;

import java.util.Date;

public class GoodsCategory {
	private Integer id;
	private Integer parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Integer isParent;
	private Date createdTime;
	private String createdUser;
	private Date modifiedTime;
	private String modifiedUser;
	public GoodsCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsCategory(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, Integer isParent,
			Date createdTime, String createdUser, Date modifiedTime, String modifiedUser) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrder = sortOrder;
		this.isParent = isParent;
		this.createdTime = createdTime;
		this.createdUser = createdUser;
		this.modifiedTime = modifiedTime;
		this.modifiedUser = modifiedUser;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", isParent=" + isParent + ", createdTime=" + createdTime
				+ ", createdUser=" + createdUser + ", modifiedTime=" + modifiedTime + ", modifiedUser=" + modifiedUser
				+ "]";
	}
	

}
