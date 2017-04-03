package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;

import com.ehome.dts.wx.common.entity.CommonModel;


/**
 * @author yangxi
 */
public class Sku extends CommonModel implements Serializable{
	private static final long serialVersionUID = -3068882796193455413L;
	public static final int NONE_NUM = -99999;//默认库存
	private int commodityId;
	private String name;
	private float price;
	private float num;//库存为-99999时表示无限大
	
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
