package com.ehome.dts.wx.common.bean.result;

import java.util.List;

/**
 * @author yangxi
 */
public class Home {
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	private String name;//项目名
	private Integer areaLevel;
	private long userId;
	private int areaId;//用户选择的最小级别的区域ID
	private String areaDetail;//区域详情
	private String addrDetail;//地址
	private String contacts;//联系人   结构为：名字，电话；名字，电话
	private String plotName;//小区名字
	private String qrCode;//二维码
	private List<HomeUserrole> homeUserroles;
	private List<Consignee> consignees;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaDetail() {
		return areaDetail;
	}
	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPlotName() {
		return plotName;
	}
	public void setPlotName(String plotName) {
		this.plotName = plotName;
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
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public List<HomeUserrole> getHomeUserroles() {
		return homeUserroles;
	}
	public void setHomeUserroles(List<HomeUserrole> homeUserroles) {
		this.homeUserroles = homeUserroles;
	}
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
}
