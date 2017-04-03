package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;

import org.hibernate.annotations.Type;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * 客户跟进记录
 * @author yangxi
 */
//@Entity
//@Table(name="customer_act")
//@DynamicUpdate(true)
public class CustomerAct extends CommonModel implements Serializable{
	private static final long serialVersionUID = 7220240522037995157L;
	private int shopId;//店铺id
	private int customerId;//店铺客户Id
	private int typeId;//记录类型
	private String actName;//记录类型名称
	private String staffName;//操作员工
	private int staffId;//操作员工
	@Type(type="text")
	private String content;//记录详情
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getActName() {
		return actName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
}
