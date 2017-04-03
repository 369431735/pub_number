package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * @author yangxi
 */
public class Commodity extends CommonModel implements Serializable {
	/**
	 * 上架
	 */
	public static final int STATE_SALE = 0;
	/**
	 * 下架
	 */
	public static final int STATE_UNSALE = 1;
	
	/**
	 * 普通商品
	 */
	public static final int TYPE_NOMAL = 0;
	/**
	 * 套餐商品
	 */
	public static final int TYPE_GROUP = 1;

	private static final long serialVersionUID = 2598360591294472283L;
	private String name;
	private int type;//商品类型
	@Column(precision = 13, scale = 2) 
	private double discount;//套餐商品中的折扣
	@Column(precision = 13, scale = 2) 
	private double price;//套餐商品中的价格
	private int nums;//几种商品
	private int createUserId;
	private int createStaffId;
	private Integer categoryId;
	private String content;// 商品名称
	private Integer shopGroupId;
	private int afterSalesTime;// 售后时间，单位为月
	private int state;// 是否下架 0：上架；1：下架。
	private int shopId;
	private int brandId;// 调整后实际为shopBrandId
	@Transient
	private long usedCount;//被几个组合商品使用
	private String unit;// 单位
	private String showPrice;//展示价格
	private String remark;// 备注
	private String qrCode;// 二维码字符串,添加商品后一旦生成就不变了，所以可以做永久保存
	@Type(type = "text")
	private String pics;// 商品图片，用";"隔开，第一个为封面
	@Type(type = "text")
	private String hisCommoditiesJson;//套餐商品中的基本商品数据库存储
	@Transient
	private String brandName;//品牌名
	@Transient
	private String preQrNumber;//二维码
	@Transient
	private List<Sku> skus;//型号
	@Transient
	private List<HisCommodity> hisCommodities;//套餐商品中的基本商品
	// 图片列表
	private List<String> imageUrlList;
	
	
	public String getPics() {
		return pics;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public long getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(long usedCount) {
		this.usedCount = usedCount;
	}

	public List<HisCommodity> getHisCommodities() {
		return hisCommodities;
	}

	public String getHisCommoditiesJson() {
		return hisCommoditiesJson;
	}

	public void setHisCommoditiesJson(String hisCommoditiesJson) {
		this.hisCommoditiesJson = hisCommoditiesJson;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public void setHisCommodities(List<HisCommodity> hisCommodities) {
		this.hisCommodities = hisCommodities;
	}

	public int getBrandId() {
		return brandId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getContent() {
		return content;
	}

	public int getCreateStaffId() {
		return createStaffId;
	}

	public void setCreateStaffId(int createStaffId) {
		this.createStaffId = createStaffId;
	}

	public int getAfterSalesTime() {
		return afterSalesTime;
	}

	public void setAfterSalesTime(int afterSalesTime) {
		this.afterSalesTime = afterSalesTime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getShopGroupId() {
		return shopGroupId;
	}

	public String getPreQrNumber() {
		return preQrNumber;
	}

	public void setPreQrNumber(String preQrNumber) {
		this.preQrNumber = preQrNumber;
	}

	public void setShopGroupId(Integer shopGroupId) {
		this.shopGroupId = shopGroupId;
	}

	public int getState() {
		return state;
	}

	/**
	 * <a href="xi.yang@i-jia.net">yangxi</a>
	 * 
	 * @param state
	 *            是否下架 0：上架；1：下架。
	 */
	public void setState(int state) {
		this.state = state;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<String> getImageUrlList() {
		return imageUrlList;
	}

	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
}
