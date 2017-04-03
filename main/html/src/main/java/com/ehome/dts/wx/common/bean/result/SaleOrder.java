package com.ehome.dts.wx.common.bean.result;

import java.util.List;

import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * @author yangxi
 */
public class SaleOrder {
	/**
	 * 订单状态，进行中
	 */
	public static final int STATE_NOT_COMPLETE = 0;
	/**
	 * 订单状态，售后状态（已完成订单）
	 */
	public static final int STATE_COMPLETE = 1;
	/**
	 * 订单状态，已退单（商品退完）获取已取消
	 * 不在列表中显示
	 */
	public static final int STATE_RETRUNED = 2;
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	private String orderNumber;//订单号
	private int customerId;
	private int staffUserId;
	private int customerUserId;
	private int shopId;
	private int staffId;
	private int addressId;
	private int relatedOrderId;//相关订单Id，补单记录原订单Id
	private double itemAmount;//商品总价
	private double favorableAmount;//优惠金额,负数
	private double totalAmount;//原订单总价=商品总价+其他费用-优惠
	private double totalReturnAmount;//退单总金额
	private double totalPayAmount;//销售额=原订单金额-退单总金额
	private double payAmount;//已付款
	private double unPayAmount;//未付款=销售额-已付款
	private double deposit;//订金
	private boolean retCommodity;//是否有退货
	private boolean cancel;//是否已取消
	private long placeOrderTime;//下单时间
	private long doneOrderTime;//订单完成时间
	private int state;//订单状态
	private int homeId;//哪个项目
	private boolean matched;//订单是否被接收
	private boolean locked;//订单是否被锁定
	private String showTime;//订单列表显示时间
	@Transient
	private boolean offset;//订单修改的时候是否做自动冲抵
	@Type(type="text")
	private String staffString;//staffId集合，保存参与人，用“;”分隔
	@Transient
	private List<OrderTime> orderTimes;//订单时间列表（小状态）
	@Transient
	private List<OrderPic> orderPics;//附件
	@Transient
	private List<Staff> staffs;//参与人
	@Transient
	private List<SaleOrder> relatedOrders;//相关订单，包括补单
	@Transient
	private List<ReturnSaleOrder> relatedRetOrders;//相关退单
	@Transient
	private List<PayAmount> payAmounts;//支付明细列表
	@Transient
	private List<OrderAct> orderActs;//修改动作列表
	@Transient
	private List<SaleItemCommodity> commodityItems;//商品明细列表
	@Transient
	private List<SaleItemAmount> amountItems;//费用明细列表
	@Transient
	private Shop shop;//店铺信息
	@Transient
	private Customer customer;//客户信息
	@Transient
	private Address address;//收货人信息
	
	private String viewCustomerJson;//改版后的客户信息
	
	private ViewCustomer viewCustomer;
	
	@Transient
	private Staff staff;//员工信息
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
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStaffUserId() {
		return staffUserId;
	}
	public void setStaffUserId(int staffUserId) {
		this.staffUserId = staffUserId;
	}
	public int getCustomerUserId() {
		return customerUserId;
	}
	public void setCustomerUserId(int customerUserId) {
		this.customerUserId = customerUserId;
	}
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
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getRelatedOrderId() {
		return relatedOrderId;
	}
	public void setRelatedOrderId(int relatedOrderId) {
		this.relatedOrderId = relatedOrderId;
	}
	public double getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
	}
	public double getFavorableAmount() {
		return favorableAmount;
	}
	public void setFavorableAmount(double favorableAmount) {
		this.favorableAmount = favorableAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTotalReturnAmount() {
		return totalReturnAmount;
	}
	public void setTotalReturnAmount(double totalReturnAmount) {
		this.totalReturnAmount = totalReturnAmount;
	}
	public double getTotalPayAmount() {
		return totalPayAmount;
	}
	public void setTotalPayAmount(double totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public double getUnPayAmount() {
		return unPayAmount;
	}
	public void setUnPayAmount(double unPayAmount) {
		this.unPayAmount = unPayAmount;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public boolean isRetCommodity() {
		return retCommodity;
	}
	public void setRetCommodity(boolean retCommodity) {
		this.retCommodity = retCommodity;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	public long getPlaceOrderTime() {
		return placeOrderTime;
	}
	public void setPlaceOrderTime(long placeOrderTime) {
		this.placeOrderTime = placeOrderTime;
	}
	public long getDoneOrderTime() {
		return doneOrderTime;
	}
	public void setDoneOrderTime(long doneOrderTime) {
		this.doneOrderTime = doneOrderTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public boolean isOffset() {
		return offset;
	}
	public void setOffset(boolean offset) {
		this.offset = offset;
	}
	public String getStaffString() {
		return staffString;
	}
	public void setStaffString(String staffString) {
		this.staffString = staffString;
	}
	public List<OrderTime> getOrderTimes() {
		return orderTimes;
	}
	public void setOrderTimes(List<OrderTime> orderTimes) {
		this.orderTimes = orderTimes;
	}
	public List<OrderPic> getOrderPics() {
		return orderPics;
	}
	public void setOrderPics(List<OrderPic> orderPics) {
		this.orderPics = orderPics;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	public List<SaleOrder> getRelatedOrders() {
		return relatedOrders;
	}
	public void setRelatedOrders(List<SaleOrder> relatedOrders) {
		this.relatedOrders = relatedOrders;
	}
	public List<ReturnSaleOrder> getRelatedRetOrders() {
		return relatedRetOrders;
	}
	public void setRelatedRetOrders(List<ReturnSaleOrder> relatedRetOrders) {
		this.relatedRetOrders = relatedRetOrders;
	}
	public List<PayAmount> getPayAmounts() {
		return payAmounts;
	}
	public void setPayAmounts(List<PayAmount> payAmounts) {
		this.payAmounts = payAmounts;
	}
	public List<OrderAct> getOrderActs() {
		return orderActs;
	}
	public void setOrderActs(List<OrderAct> orderActs) {
		this.orderActs = orderActs;
	}
	public List<SaleItemCommodity> getCommodityItems() {
		return commodityItems;
	}
	public void setCommodityItems(List<SaleItemCommodity> commodityItems) {
		this.commodityItems = commodityItems;
	}
	public List<SaleItemAmount> getAmountItems() {
		return amountItems;
	}
	public void setAmountItems(List<SaleItemAmount> amountItems) {
		this.amountItems = amountItems;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public ViewCustomer getViewCustomer() {
		return viewCustomer;
	}
	public void setViewCustomer(ViewCustomer viewCustomer) {
		this.viewCustomer = viewCustomer;
	}
	public String getViewCustomerJson() {
		return viewCustomerJson;
	}
	public void setViewCustomerJson(String viewCustomerJson) {
		this.viewCustomerJson = viewCustomerJson;
	}
}
