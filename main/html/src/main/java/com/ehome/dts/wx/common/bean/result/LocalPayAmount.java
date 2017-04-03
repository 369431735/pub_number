package com.ehome.dts.wx.common.bean.result;


/**
 * 付款记录
 * @author yangxi
 */
public class LocalPayAmount{
	
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
	
	private long payTime;
	private float amount;
	private int orderId;//订单Id
	private int paymentWay;//1：现金；2：刷卡（非现金）
	private int type;//收入、支出、冲抵
	private int userId;
	private int homeId;
	private boolean deposit;//是否是定金
	
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
	public int getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(int paymentWay) {
		this.paymentWay = paymentWay;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public boolean isDeposit() {
		return deposit;
	}
	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}
}
