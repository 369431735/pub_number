package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * 客户楼盘
 * @author yangxi
 */
//@Entity
//@Table(name="customer_plot")
//@DynamicUpdate(true)
public class CustomerPlot extends CommonModel implements Serializable{
	private static final long serialVersionUID = 2139362147726357507L;
	private int customerId;//客户Id
	private String name;//楼盘名称
	private int areaId;//区域id
	private String areaName;//区域名
	private String address;//地址
	private String houseNumber;//门牌号
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getName() {
		return name;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
