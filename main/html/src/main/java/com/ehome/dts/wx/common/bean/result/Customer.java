package com.ehome.dts.wx.common.bean.result;



/**
 * @author yangxi
 */
public class Customer{
	private int shopId;
	private int staffId;//员工id
	private int staffUserId;//员工的用户id
	
	private int userId;//哪个用户
	private String phoneNumber;//电话
	private String remark;//客户昵称
	private String content;//备注
	private String imgUrl;//客户头像
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
	public int getStaffUserId() {
		return staffUserId;
	}
	public void setStaffUserId(int staffUserId) {
		this.staffUserId = staffUserId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRemark() {
		return remark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
