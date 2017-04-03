package com.ehome.dts.wx.common.bean.result;

import javax.persistence.Transient;

/**
 * 关注足迹，其实是用户扫码和浏览的足迹，有一次记一次，不去重
 * @author yangxi
 */
public class CommodityTrack{
	protected Long modelId;
	protected Long createTime;
	protected Long updateTime;
	protected boolean deleted;
	private int userId;//用户Id
	private String openId;//微信openId
	private int commodityId;//扫码关注Commodity的modelId
	
	@Transient
	private UserCommodity userCommodity;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public UserCommodity getUserCommodity() {
		return userCommodity;
	}
	public void setUserCommodity(UserCommodity userCommodity) {
		this.userCommodity = userCommodity;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
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
}
