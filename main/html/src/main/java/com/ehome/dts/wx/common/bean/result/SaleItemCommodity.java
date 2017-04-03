package com.ehome.dts.wx.common.bean.result;



/**
 * @author yangxi
 */
public class SaleItemCommodity {
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	private HisCommodity hisCommodity;
	private int saleOrderId;
	private int commodityId;//方便做数据统计
	private int shopId;//方便做数据统计
	private int staffUserId;//方便做数据统计
	private float quantity;
	private float retQuantity;//可退数量
	private float salePrice;
	private float amount;
	private float discount;
	private boolean matched;//是否被匹配
	private String warranty;//质保期（天）
	private String content;//备注
	public HisCommodity getHisCommodity() {
		return hisCommodity;
	}

	public void setHisCommodity(HisCommodity hisCommodity) {
		this.hisCommodity = hisCommodity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getSalePrice() {
		return salePrice;
	}
	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public boolean isMatched() {
		return matched;
	}
	public int getStaffUserId() {
		return staffUserId;
	}

	public void setStaffUserId(int staffUserId) {
		this.staffUserId = staffUserId;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
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

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public float getAmount() {
		return amount;
	}

	public float getRetQuantity() {
		return retQuantity;
	}

	public void setRetQuantity(float retQuantity) {
		this.retQuantity = retQuantity;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

}
