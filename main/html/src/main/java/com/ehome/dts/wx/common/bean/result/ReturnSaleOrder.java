package com.ehome.dts.wx.common.bean.result;

import java.util.List;

/**
 * 销售退货单实体类
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class ReturnSaleOrder{
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	private String orderNumber;//退单号
	private String saleOrderNumber;//相关订单号
	private int saleOrderId;//相关订单Id
	private long returnOrderTime;//退单时间
	private int shopId;
	private int customerUserId;
	private int customerId;
	private int addressId;
	private int staffId;
	private int homeId;
	private float itemAmount;//商品总价
	private float otherItemAmount;//其他费用总价+优惠
	private float diffAmount;//退款差额（扣除费用）,可为正可为负
	private float totalAmount;//订单总价
	private float totalRetAmount;//实际退款金额
	private float totalOffsetAmount;//实际冲抵总金额
	private String remark;//备注
	private boolean offset;//订单修改的时候是否做自动冲抵
	private List<ReturnItem> returnItems;//商品明细
	private List<PayAmount> payAmounts;//退款明细
	private Shop shop;
	private Customer customer;
	private Address address;
	private Staff staff;
	private SaleOrder relatedOrder;//相关订单
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
	public boolean isOffset() {
		return offset;
	}
	public void setOffset(boolean offset) {
		this.offset = offset;
	}
	public String getSaleOrderNumber() {
		return saleOrderNumber;
	}
	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}
	public int getSaleOrderId() {
		return saleOrderId;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public int getCustomerUserId() {
		return customerUserId;
	}
	public float getTotalRetAmount() {
		return totalRetAmount;
	}
	public void setTotalRetAmount(float totalRetAmount) {
		this.totalRetAmount = totalRetAmount;
	}
	public float getTotalOffsetAmount() {
		return totalOffsetAmount;
	}
	public void setTotalOffsetAmount(float totalOffsetAmount) {
		this.totalOffsetAmount = totalOffsetAmount;
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
	public float getDiffAmount() {
		return diffAmount;
	}
	public void setDiffAmount(float diffAmount) {
		this.diffAmount = diffAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public long getReturnOrderTime() {
		return returnOrderTime;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public SaleOrder getRelatedOrder() {
		return relatedOrder;
	}
	public void setRelatedOrder(SaleOrder relatedOrder) {
		this.relatedOrder = relatedOrder;
	}
	public void setReturnOrderTime(long returnOrderTime) {
		this.returnOrderTime = returnOrderTime;
	}
	public List<ReturnItem> getReturnItems() {
		return returnItems;
	}
	public void setReturnItems(List<ReturnItem> returnItems) {
		this.returnItems = returnItems;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<PayAmount> getPayAmounts() {
		return payAmounts;
	}
	public float getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(float itemAmount) {
		this.itemAmount = itemAmount;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setPayAmounts(List<PayAmount> payAmounts) {
		this.payAmounts = payAmounts;
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public float getOtherItemAmount() {
		return otherItemAmount;
	}
	public void setOtherItemAmount(float otherItemAmount) {
		this.otherItemAmount = otherItemAmount;
	}
}
