package com.ehome.dts.wx.common.bean.result;

import javax.persistence.Transient;

/**
 * 付款记录
 * @author yangxi
 */
public class PayAmount{
	/**
	 * 收款
	 */
	public static final int TYPE_ORDER = 0;
	/**
	 * 退款
	 */
	public static final int TYPE_RETURN = 1;
	/**
	 * 冲抵
	 */
	public static final int TYPE_OFFSET = 2;
	
	/**
	 * 支付渠道类型，现金
	 */
	public static final int PAYMENT_WAY_CASH = 1;
	/**
	 * 支付渠道类型，刷卡
	 */
	public static final int PAYMENT_WAY_CARD = 2;

	/**
	 * 支付渠道类型，账户转账
	 */
	public static final int PAYMENT_WAY_ACCOUNT = 3;

	
	public static final int ORDER_TYPE_NONE = 1;//订单
	@Deprecated
	public static final int ORDER_TYPE_ADD = 2;//补单，已废弃 
	public static final int ORDER_TYPE_RETURN = 3;//退单
	
	private long payTime;
	private float amount;//负的表示退款，正的表示收款
	private int orderId;//订单Id
	private String orderNumber;//订单号
	private int returnOrderId;//退单Id
	private String returnOrderNumber;//退单号
	private int staffId;
	private int staffUserId;
	private int shopId;
	private int paymentWay;//1：现金；2：刷卡（非现金）
	private int type;//收入、支出、冲抵
	private int orderType;//订单类型
	private boolean deposit;//是否是定金
	private boolean selfOffset;//是否是本单冲抵
	@Transient
	private String payUserName;//员工名或用户名
	public long getPayTime() {
		return payTime;
	}
	public void setPayTime(long payTime) {
		this.payTime = payTime;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getStaffId() {
		return staffId;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public boolean isSelfOffset() {
		return selfOffset;
	}
	public void setSelfOffset(boolean selfOffset) {
		this.selfOffset = selfOffset;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getPayUserName() {
		return payUserName;
	}
	public void setPayUserName(String payUserName) {
		this.payUserName = payUserName;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(int paymentWay) {
		this.paymentWay = paymentWay;
	}
	public int getReturnOrderId() {
		return returnOrderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getReturnOrderNumber() {
		return returnOrderNumber;
	}
	public void setReturnOrderNumber(String returnOrderNumber) {
		this.returnOrderNumber = returnOrderNumber;
	}
	public void setReturnOrderId(int returnOrderId) {
		this.returnOrderId = returnOrderId;
	}
	public int getStaffUserId() {
		return staffUserId;
	}
	public void setStaffUserId(int staffUserId) {
		this.staffUserId = staffUserId;
	}
	public boolean isDeposit() {
		return deposit;
	}
	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}
}
