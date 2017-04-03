package com.ehome.dts.wx.common.bean.result;


/**
 * @author yangxi
 */
public class SaleItemAmount{
	private int saleOrderId;
	private int projectId;//Project的modelId
	private String projectName;//*名字，Project的name
	private int shopId;//商店Id
    private float amount;//价格
    
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectId() {
		return projectId;
	}
	public int getSaleOrderId() {
		return saleOrderId;
	}
	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
