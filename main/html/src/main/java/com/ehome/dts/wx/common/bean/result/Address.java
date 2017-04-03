package com.ehome.dts.wx.common.bean.result;

import java.util.List;


/**
 * @author yangxi
 */
public class Address{
	private int userId;//哪个用户
	private String address;//详细地址
	private String contacts;//联系人 （收货人和收货电话） 结构为：名字，电话；名字，电话
	private int areaId;//细化区域id
	private String areaDetail;//细化区域值
	private String remark;//备注
	private List<Consignee> consignees;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
}
