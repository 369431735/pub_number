package com.ehome.dts.wx.common.bean.result;


/**
 * 本地订单其他费用
 * @author yangxi
 */
public class LocalItem{
	private int projectId;//项目Id
	private int localOrderId;//订单Id
	private String projectName;//项目名，要加个其他费用
	private float amount;//价格
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getLocalOrderId() {
		return localOrderId;
	}
	public void setLocalOrderId(int localOrderId) {
		this.localOrderId = localOrderId;
	}
}
