package com.ehome.dts.wx.common.bean.result;



/**
 * @author yangxi
 */
public class HomeOrder{
	public static final int TYPE_SALE_ORDER = 1;
	public static final int TYPE_LOCAL_ORDER = 2;
	@Deprecated
	public static final int TYPE_RETURN_ORDER = 3;
	private int type;
	private Home home;
	private SaleOrder saleOrder;
	private LocalOrder localOrder;
	private ReturnSaleOrder returnSaleOrder;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	public LocalOrder getLocalOrder() {
		return localOrder;
	}
	public void setLocalOrder(LocalOrder localOrder) {
		this.localOrder = localOrder;
	}
	public ReturnSaleOrder getReturnSaleOrder() {
		return returnSaleOrder;
	}
	public void setReturnSaleOrder(ReturnSaleOrder returnSaleOrder) {
		this.returnSaleOrder = returnSaleOrder;
	}
}
