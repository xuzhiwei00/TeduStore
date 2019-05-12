package cn.tedu.store.bean;

public class Provinces {
	private Integer id;
	private String provinceCode;
	private String provinceName;
	public Provinces() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provinces(Integer id, String provinceCode, String provinceName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;	
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Provinces [id=" + id + ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}
	
}
