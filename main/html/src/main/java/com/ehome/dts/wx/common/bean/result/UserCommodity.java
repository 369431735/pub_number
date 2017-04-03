package com.ehome.dts.wx.common.bean.result;

import java.util.List;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * 关注
 * @author yangxi
 */
public class UserCommodity extends CommonModel {
	/**
	 * 手动关注
	 */
	public static final int TYPE_USER = 1;
	/**
	 * 扫码关注
	 */
	public static final int TYPE_SHOP = 2;
	private int userId;//用户Id
	private String name;//商品名称
	private double price;//询价
	private double skuPrice;//商品关注价格
	private double curPrice;//商品当前价格
	private double updatePrice;//最新查看的商品价格
	private String pics;//自定义商品图片
	private String shopName;//手动关注店铺名称
	private String shopAddress;//手动关注店铺地址
	private String shopPhonenumber;//手动关注店铺电话
	private String content;//自己的备注
	private String openId;//微信openId
	private double num;//库存为-99999时表示无限大
	private int type;//关注类型
	private int commodityId;//扫码关注Commodity的modelId
	private int skuId;//扫码关注Sku的modelId
	private boolean unsale;//是否下架
	private boolean updated;//是否有价格更新
	private boolean footprinted;//是否关注公众号
	private String nSkuString;//所有型号价格对比
	
	private List<String> imageUrlList;  // 2.2.0 图片列表，七牛
	
	private Shop shop;
	private Commodity commodity;
	private Sku sku;
	private List<NSku> nskus;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public boolean isFootprinted() {
		return footprinted;
	}
	public void setFootprinted(boolean footprinted) {
		this.footprinted = footprinted;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isUpdated() {
		return updated;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public String getnSkuString() {
		return nSkuString;
	}
	public double getUpdatePrice() {
		return updatePrice;
	}
	public void setUpdatePrice(double updatePrice) {
		this.updatePrice = updatePrice;
	}
	public void setnSkuString(String nSkuString) {
		this.nSkuString = nSkuString;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public List<NSku> getNskus() {
		return nskus;
	}
	public void setNskus(List<NSku> nskus) {
		this.nskus = nskus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCurPrice() {
		return curPrice;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}
	public String getPics() {
		return pics;
	}
	public boolean isUnsale() {
		return unsale;
	}
	public void setUnsale(boolean unsale) {
		this.unsale = unsale;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopPhonenumber() {
		return shopPhonenumber;
	}
	public void setShopPhonenumber(String shopPhonenumber) {
		this.shopPhonenumber = shopPhonenumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(double skuPrice) {
		this.skuPrice = skuPrice;
	}
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
}
