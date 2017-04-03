package com.ehome.dts.wx.common.bean.result;


/**
 * @author yangxi
 */
public class LocalCommodity{
	private int localOrderId;//订单Id
	private String name;//商品名
	private float price;//单价
	private float num;//数量
	private float amount;//总价
	private boolean matched;//是否被匹配
	private String pics;//图片地址
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
	public int getLocalOrderId() {
		return localOrderId;
	}
	public void setLocalOrderId(int localOrderId) {
		this.localOrderId = localOrderId;
	}
	public float getAmount() {
		return amount;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
}
