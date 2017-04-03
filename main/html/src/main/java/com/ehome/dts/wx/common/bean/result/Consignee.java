package com.ehome.dts.wx.common.bean.result;

import java.io.Serializable;

public class Consignee implements Serializable{
	private static final long serialVersionUID = 3684862849343666051L;
	private String phoneNumber;//收货电话
    private String userName;//收货人

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Consignee() {
	}
    public Consignee(String phoneNumber, String userName) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }
}
