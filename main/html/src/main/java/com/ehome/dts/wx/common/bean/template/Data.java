package com.ehome.dts.wx.common.bean.template;


/**
 * {{first.DATA}}<br/>
 * 订单编号：{{keyword1.DATA}}<br/>
 * 商品名称：{{keyword2.DATA}}<br/>
 * 订单金额：{{keyword3.DATA}}<br/>
 * 商户名称：{{keyword4.DATA}}<br/>
 * 交易提醒：{{keyword5.DATA}}<br/>
 * {{remark.DATA}}
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class Data{
	private PerData first;//头
	private PerData keyword1;//订单编号
	private PerData keyword2;//商品名称
	private PerData keyword3;//订单金额
	private PerData keyword4;//商户名称
	private PerData keyword5;//交易提醒
	private PerData remark;//简介
	public PerData getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(PerData keyword1) {
		this.keyword1 = keyword1;
	}
	public PerData getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(PerData keyword2) {
		this.keyword2 = keyword2;
	}
	public PerData getFirst() {
		return first;
	}
	public void setFirst(PerData first) {
		this.first = first;
	}
	public PerData getRemark() {
		return remark;
	}
	public void setRemark(PerData remark) {
		this.remark = remark;
	}
	public PerData getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(PerData keyword3) {
		this.keyword3 = keyword3;
	}
	public PerData getKeyword4() {
		return keyword4;
	}
	public void setKeyword4(PerData keyword4) {
		this.keyword4 = keyword4;
	}
	public PerData getKeyword5() {
		return keyword5;
	}
	public void setKeyword5(PerData keyword5) {
		this.keyword5 = keyword5;
	}
}