package com.ehome.dts.wx.oldcontroller.result;

import org.springframework.stereotype.Component;

@Component
public class GMResult {
	private int act;
	private Object result;
	public void isSuccess(){
		this.act = 0;
	}
	public int getAct() {
		return act;
	}
	public void setAct(int act) {
		this.act = act;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
