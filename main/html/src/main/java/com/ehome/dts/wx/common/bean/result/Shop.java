package com.ehome.dts.wx.common.bean.result;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * @author yangxi
 */
public class Shop {
	protected Long modelId;
	private String name;
	private Integer areaLevel;
	private int areaId;//用户选择的最小级别的区域ID
	private String areaDetail;
	private String addrDetail;
	private String boss;//老板
	private String tels;//电话
	private Integer shopGroupId;
	private String logoUrl;
	private String content;
	private String instructions;
	private Double discountPoint;
	private Double prepaidPoint;
	private Integer marketId;
	private String marketName;
	private String code;//邀请码
	// 完整图片地址
	private String imageUrl;
	// 坐标
	private String location;
	
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaDetail() {
		return areaDetail;
	}
	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getTels() {
		return tels;
	}
	public void setTels(String tels) {
		this.tels = tels;
	}
	public Integer getShopGroupId() {
		return shopGroupId;
	}
	public void setShopGroupId(Integer shopGroupId) {
		this.shopGroupId = shopGroupId;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Double getDiscountPoint() {
		return discountPoint;
	}
	public void setDiscountPoint(Double discountPoint) {
		this.discountPoint = discountPoint;
	}
	public Double getPrepaidPoint() {
		return prepaidPoint;
	}
	public void setPrepaidPoint(Double prepaidPoint) {
		this.prepaidPoint = prepaidPoint;
	}
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
