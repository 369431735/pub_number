package com.ehome.dts.wx.common.bean.result;


public class NSku {
	private int skuId;
	private Sku sku;
	private double price;//关注价格，询价
	private double oldPrice;//关注时的标价
	private double curPrice;//当前价格
	private double updatePrice;//上次确定已看的标价
	
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
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
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public double getUpdatePrice() {
		return updatePrice;
	}
	public void setUpdatePrice(double updatePrice) {
		this.updatePrice = updatePrice;
	}
}
