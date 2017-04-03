package com.ehome.dts.wx.common.bean.result;

import javax.persistence.Transient;

import org.hibernate.annotations.Type;


/**
 * 订单修改记录
 * @author yangxi
 */
public class OrderAct {
	public static final int TYPE_ADDRESS = 1;//修改收货人信息
	public static final int TYPE_ORDER_TIME = 2;//修改时间信息
	@Deprecated
	public static final int TYPE_ITEM_AMOUNT = 3;//修改其他费用信息
	@Deprecated
	public static final int TYPE_COMMODITY_NUM = 4;//修改商品数量（已废弃）
	public static final int TYPE_PLACE_TIME = 5;//修改下单时间
	@Deprecated
	public static final int TYPE_FAVORABLE_AMOUNT = 6;//修改优惠信息
	public static final int TYPE_CANCEL_ORDER = 7;//取消订单
	public static final int TYPE_RETURN_ORDER = 8;//退单
	public static final int TYPE_UPDATE_ORDER = 9;//修改订单项目updateSaleOrder
	public static final int TYPE_UPDATE_ORDER_PIC = 10;//修改订单附件
	private int saleOrderId;
	private int staffId;//营业员发起修改注入
	private int userId;//用户发起修改注入
	private int shopId;//店铺Id
	private int actType;//修改类型
	private String content;//备注
	@Type(type="text")
	private String beforeChange;
	@Type(type="text")
	private String afterChange;
	@Transient
	private Staff staff;
	public int getSaleOrderId() {
		return saleOrderId;
	}
	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public int getActType() {
		return actType;
	}
	public void setActType(int actType) {
		this.actType = actType;
	}
	public String getBeforeChange() {
		return beforeChange;
	}
	public void setBeforeChange(String beforeChange) {
		this.beforeChange = beforeChange;
	}
	public String getAfterChange() {
		return afterChange;
	}
	public void setAfterChange(String afterChange) {
		this.afterChange = afterChange;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
}
