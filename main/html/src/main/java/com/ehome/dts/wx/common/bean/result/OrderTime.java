package com.ehome.dts.wx.common.bean.result;



/**
 * @author yangxi
 */
public class OrderTime {
	public static final int STATE_UNDO = 0;
	public static final int STATE_DONE = 1;
	private int saleOrderId;
	private long value;
	private int shopId;//商店Id
	private int staffId;//员工Id
	private int projectId;
	private int state;//当前时间完成状态0：未完成 1：已完成
	private String projectName;
	private String staffName;//员工名
	private String satffNumber;//员工电话
	private String content;//备注或评价
	public int getSaleOrderId() {
		return saleOrderId;
	}
	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
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
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSatffNumber() {
		return satffNumber;
	}
	public void setSatffNumber(String satffNumber) {
		this.satffNumber = satffNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
}
