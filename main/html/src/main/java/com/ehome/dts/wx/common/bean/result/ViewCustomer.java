package com.ehome.dts.wx.common.bean.result;

import java.util.List;

import javax.persistence.Transient;

/**
 * 前端用的customer对象
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class ViewCustomer {
	private int modelId;//对应数据库的ShopCustomerId
	private int groupId;
	private int userId;
	private String groupName;
	private String phoneNumber;
	private String name;
	private String nickName;
	private CustomerPlot customerPlot;//添加订单的时候注入楼盘
	private List<Consignee> consignees;//添加订单注入联系人
	private List<CustomerPlot> customerPlots;
	private List<CustomerAct> customerActs;
	private List<SaleOrder> saleOrders;
	private List<String> staffNames;
	private List<Staff> staffs;//哪些营业员参与了
	private boolean readed;
	private long updateTime;
	private String imgUrl;
	private String plotName;
	private int sex;// 0:保密；1：男；2：女
	private int age;// 年龄
	private long birthday;// 生日
	@Transient
	private List<Tag> tags;
	
	@Transient
	private String imageUrl;
	
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public long getBirthday() {
		return birthday;
	}
	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public List<CustomerPlot> getCustomerPlots() {
		return customerPlots;
	}
	public CustomerPlot getCustomerPlot() {
		return customerPlot;
	}
	public void setCustomerPlot(CustomerPlot customerPlot) {
		this.customerPlot = customerPlot;
	}
	public void setCustomerPlots(List<CustomerPlot> customerPlots) {
		this.customerPlots = customerPlots;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<CustomerAct> getCustomerActs() {
		return customerActs;
	}
	public void setCustomerActs(List<CustomerAct> customerActs) {
		this.customerActs = customerActs;
	}
	public List<SaleOrder> getSaleOrders() {
		return saleOrders;
	}
	public void setSaleOrders(List<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}
	public List<String> getStaffNames() {
		return staffNames;
	}
	public void setStaffNames(List<String> staffNames) {
		this.staffNames = staffNames;
	}
	public boolean isReaded() {
		return readed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPlotName() {
		return plotName;
	}
	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
