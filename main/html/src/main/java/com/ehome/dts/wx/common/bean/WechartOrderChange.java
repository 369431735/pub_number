package com.ehome.dts.wx.common.bean;

import com.ehome.dts.wx.common.bean.result.Message;
import com.ehome.dts.wx.common.bean.result.SaleOrder;


/**
 * 推给微信端的订单修改记录
 * @author yangxi
 */
public class WechartOrderChange{
	private Backlog backlog;
	private Message message;
	private SaleOrder saleOrder;
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
}
