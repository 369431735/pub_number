package com.ehome.dts.wx.common.bean.result;

import java.util.List;

import org.hibernate.annotations.Type;

/**
 * @author yangxi
 */
public class OrderPic{
	/**
	 * 商家订单
	 */
	public static final int TYPE_SHOP = 1;
	/**
	 * 手动订单
	 */
	public static final int TYPE_USER = 2;
	
	private int projectId;
	private String projectName;
	private int orderId;
	private int type;
	@Type(type="text")
	private String pics;
	
	// 图片地址
	private List<String> imageUrlList;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
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
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
}
