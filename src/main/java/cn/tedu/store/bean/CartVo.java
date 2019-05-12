package cn.tedu.store.bean;

public class CartVo {
	private Integer id;
	private Integer uid;
	private String goodsId;
	private String image;
	private String title;
	private Integer price;
	private Integer count;
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartVo(Integer id, Integer uid, String goodsId, String image, String title, Integer price, Integer count) {
		super();
		this.id = id;
		this.uid = uid;
		this.goodsId = goodsId;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
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
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrive(Integer prive) {
		this.price = prive;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", image=" + image + ", title=" + title
				+ ", prive=" + price + ", count=" + count + "]";
	}
	
}
