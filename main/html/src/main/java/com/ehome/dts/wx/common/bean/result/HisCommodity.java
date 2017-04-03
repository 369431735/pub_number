package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;
import java.util.List;

import com.ehome.dts.wx.common.entity.CommonModel;


/**
 * @author yangxi
 */
public class HisCommodity extends CommonModel implements Serializable{
	private static final long serialVersionUID = -7999055790205179662L;
	private int type;//类型
	private double discount;//套餐商品中的折扣
	private double num;//普通商品在套餐商品中的数量
	private double nums;//套餐商品包含几个商品
	private String commodityName;
	private int createUserId;
	private int createStaffId;
	private Integer categoryId;
	private String content;
	private Integer shopGroupId;
	private int afterSalesTime;//售后时间，单位为月
	private int state;//是否下架 0：上架；1：下架。
	private int shopId;
	private String brandName;
	private int brandId;
	private String unit;//单位
	private String showPrice;
	private String pics;//商品图片，用";"隔开，第一个为封面；
	private String skuName;
	private double price;
	private int commodityId;
	private int skuId;
	private Long commodityUpdateTime;
	private Long skuUpdateTime;
	private String hisCommoditiesJson;//包装组合商品中的基本商品，取hisCommodity的modelId和num就可以了
	private List<HisCommodity> hisCommodities;//组合商品中的基本商品
	
	// 图片地址
	private List<String> imageUrlList;
	
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	public int getCreateStaffId() {
		return createStaffId;
	}
	public String getHisCommoditiesJson() {
		return hisCommoditiesJson;
	}
	public void setHisCommoditiesJson(String hisCommoditiesJson) {
		this.hisCommoditiesJson = hisCommoditiesJson;
	}
	public double getNums() {
		return nums;
	}
	public void setNums(double nums) {
		this.nums = nums;
	}
	public void setCreateStaffId(int createStaffId) {
		this.createStaffId = createStaffId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public List<HisCommodity> getHisCommodities() {
		return hisCommodities;
	}
	public void setHisCommodities(List<HisCommodity> hisCommodities) {
		this.hisCommodities = hisCommodities;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getShopGroupId() {
		return shopGroupId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public void setShopGroupId(Integer shopGroupId) {
		this.shopGroupId = shopGroupId;
	}
	public int getAfterSalesTime() {
		return afterSalesTime;
	}
	public void setAfterSalesTime(int afterSalesTime) {
		this.afterSalesTime = afterSalesTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getShowPrice() {
		return showPrice;
	}
	public void setShowPrice(String showPrice) {
		this.showPrice = showPrice;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public Long getCommodityUpdateTime() {
		return commodityUpdateTime;
	}
	public void setCommodityUpdateTime(Long commodityUpdateTime) {
		this.commodityUpdateTime = commodityUpdateTime;
	}
	public Long getSkuUpdateTime() {
		return skuUpdateTime;
	}
	public void setSkuUpdateTime(Long skuUpdateTime) {
		this.skuUpdateTime = skuUpdateTime;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
}
