package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;

import javax.persistence.Transient;

import com.ehome.dts.wx.common.entity.CommonModel;

/**
 * 标签
 * @author yangxi
 */
//@Entity
//@Table(name="data_tag")
//@DynamicUpdate(true)
public class Tag extends CommonModel implements Serializable{
	private static final long serialVersionUID = 2077611117827491963L;
	private int shopId;//店铺id，为0表示系统自定义
	private int staffId;//所属员工，为0表示系统自定义
	private int groupId;//标签类型
	private String name;//标签名称
	private long used;//使用次数
	@Transient
	private String color;//颜色
	@Transient
	private boolean couldDeleted;//能否被删除
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public long getUsed() {
		return used;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setUsed(long used) {
		this.used = used;
	}
	public boolean isCouldDeleted() {
		return couldDeleted;
	}
	public void setCouldDeleted(boolean couldDeleted) {
		this.couldDeleted = couldDeleted;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
