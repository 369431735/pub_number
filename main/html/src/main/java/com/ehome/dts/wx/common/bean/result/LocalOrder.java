package com.ehome.dts.wx.common.bean.result;

import java.util.List;

/**
 * @author yangxi
 */
public class LocalOrder{
	/**
	 * 订单状态，进行中
	 */
	public static final int STATE_NOT_COMPLETE = 0;
	/**
	 * 订单状态，售后状态（已完成订单）
	 */
	public static final int STATE_COMPLETE = 1;
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	private int homeId;
	private int userId;
	private int state;
	private String orderNumber;//订单号
	private long placeOrderTime;//下单时间
	
	private String shopName;//店铺名
	private String phoneNumber;//店铺电话
	private String staffName;//联系人
	private String staffNumber;//联系电话
	
	private float totalAmount;//订单总费用
	private float favorableAmount;//优惠金额,负数
	private float totalPayAmount;//应付款总价
	private float payAmount;//订单已付款
	private float unPayAmount;//未付款
	private float deposit;//订金
	
	private int areaId;//细化区域id
	private String areaDetail;//细化区域值
	private int marketId;//商场Id
	private String marketName;//商场名
	private String content;//备注
	private List<LocalCommodity> localCommodities;//商品
	private List<LocalItem> localItems;//其他费用
	private List<OrderPic> orderPics;//附件
	private List<LocalPayAmount> localPayAmounts;//付款记录
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public long getPlaceOrderTime() {
		return placeOrderTime;
	}
	public void setPlaceOrderTime(long placeOrderTime) {
		this.placeOrderTime = placeOrderTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public List<OrderPic> getOrderPics() {
		return orderPics;
	}
	public void setOrderPics(List<OrderPic> orderPics) {
		this.orderPics = orderPics;
	}
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getPayAmount() {
		return payAmount;
	}
	public List<LocalPayAmount> getLocalPayAmounts() {
		return localPayAmounts;
	}
	public void setLocalPayAmounts(List<LocalPayAmount> localPayAmounts) {
		this.localPayAmounts = localPayAmounts;
	}
	public void setPayAmount(float payAmount) {
		this.payAmount = payAmount;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public float getFavorableAmount() {
		return favorableAmount;
	}
	public void setFavorableAmount(float favorableAmount) {
		this.favorableAmount = favorableAmount;
	}
	public float getTotalPayAmount() {
		return totalPayAmount;
	}
	public void setTotalPayAmount(float totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}
	public float getUnPayAmount() {
		return unPayAmount;
	}
	public void setUnPayAmount(float unPayAmount) {
		this.unPayAmount = unPayAmount;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
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
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public List<LocalCommodity> getLocalCommodities() {
		return localCommodities;
	}
	public void setLocalCommodities(List<LocalCommodity> localCommodities) {
		this.localCommodities = localCommodities;
	}
	public List<LocalItem> getLocalItems() {
		return localItems;
	}
	public void setLocalItems(List<LocalItem> localItems) {
		this.localItems = localItems;
	}
}
