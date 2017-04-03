package com.ehome.dts.wx.common.bean;


/**
 * @author yangxi
 */
public class Backlog{
	private Integer modelId;
	private Long createTime;
	private Long updateTime;
	private boolean deleted;
	/**
	 * 商家端发出，新订单，确认和忽略
	 * 完成前是SaleOrder
	 * 完成后是HomeOrder
	 * 处理时object为homeId
	 */
	public static final int TYPE_NEW_ORDER = 1;
	/**
	 * 商家端发出，新退单，知道了
	 */
	public static final int TYPE_NEW_RETURNORDER = 2;
	/**
	 * 商家端发出，确认退单，确认和拒绝，锁定订单
	 */
	public static final int TYPE_CONFIRM_RETURNORDER = 3;
	/**
	 * 商家端发出，修改订单，确认和拒绝，锁定订单
	 */
	public static final int TYPE_CONFIRM_UPDATEORDER = 14;
	/**
	 * 商家端发出，修改时间，确认，立即修改
	 * objectId为orderActId
	 */
	public static final int TYPE_VIEW_ORDER_TIME = 7;
	/**
	 * 商家端发出，收款，确认，立即修改
	 */
	public static final int TYPE_VIEW_PAYAMOUNT = 8;
	/**
	 * 商家端发出，修改收货人，确认，立即修改
	 * objectId为saleOrderId
	 */
	public static final int TYPE_VIEW_ADDRESS = 9;
	/**
	 * 商家端发出，取消订单，确认，立即修改
	 * 用户接收后不能取消订单，只能走退单流程
	 */
	@Deprecated
	public static final int TYPE_VIEW_CANNEL_ORDER = 10;
	/**
	 * 商家端发出，修改附件，确认，立即修改
	 */
	public static final int TYPE_VIEW_ORDER_PIC = 15;
	/**
	 * 商家端发出，催款，确认
	 */
	public static final int TYPE_VIEW_ORDER_REMIND = 17;
	
	
	/**
	 * 客户端发出，退货申请，操作和拒绝，锁定订单
	 */
	public static final int TYPE_APPLY_RETURNORDER = 11;
	/**
	 * 客户端发出，修改收货人，操作和拒绝，锁定订单
	 * objectString为AddressJson
	 * objectId为saleOrderId
	 */
	public static final int TYPE_APPLY_ADDRESS = 12;
	/**
	 * 客户端发出，补货申请，操作和拒绝，锁定订单
	 */
	public static final int TYPE_APPLY_SALEORDER = 13;
	/**
	 * 客户端发出，申请售后，知道了
	 */
	public static final int TYPE_APPLY_ASSURANCE = 16;
	
	/**
	 * 未完成，未同意
	 */
	public static final int STATE_UNDO = 1;
	/**
	 * 已完成，已同意,知道了
	 */
	public static final int STATE_DONE = 2;
	/**
	 * 已拒绝
	 */
	public static final int STATE_REFUSE = 3;
	/**
	 * 已取消
	 */
	public static final int STATE_CANCEL = 4;
	
	private int type;//类型
	private int saleOrderId;//订单Id
	private int objectId;//对象Id
	private int doneObjId;//完成结果对象Id
	private String objectString;//暂存对象
	private Object object;
	private int state;
	private boolean ignorable;//订单状态是否可被忽略
	
	public Backlog() {
		this.state = STATE_UNDO;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public Object getObject() {
		return object;
	}
	public int getState() {
		return state;
	}
	public int getDoneObjId() {
		return doneObjId;
	}
	public void setDoneObjId(int doneObjId) {
		this.doneObjId = doneObjId;
	}
	public int getSaleOrderId() {
		return saleOrderId;
	}
	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public boolean isIgnorable() {
		return ignorable;
	}
	public void setIgnorable(boolean ignorable) {
		if(ignorable){
			this.state = STATE_DONE;
		}
		this.ignorable = ignorable;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getObjectString() {
		return objectString;
	}
	public void setObjectString(String objectString) {
		this.objectString = objectString;
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
}
