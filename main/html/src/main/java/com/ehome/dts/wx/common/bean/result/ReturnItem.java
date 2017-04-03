package com.ehome.dts.wx.common.bean.result;



/**
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class ReturnItem{
	private int returnSaleOrderId;
    private float quantity;//数量
    private float returnPrice;
    private float amount;
    private int projectId;
    private int commodityId;
	private String projectName;
    private HisCommodity hisCommodity;
	public int getReturnSaleOrderId() {
		return returnSaleOrderId;
	}
	public void setReturnSaleOrderId(int returnSaleOrderId) {
		this.returnSaleOrderId = returnSaleOrderId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(float returnPrice) {
		this.returnPrice = returnPrice;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public HisCommodity getHisCommodity() {
		return hisCommodity;
	}
	public void setHisCommodity(HisCommodity hisCommodity) {
		this.hisCommodity = hisCommodity;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
