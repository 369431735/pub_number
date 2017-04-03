package com.ehome.dts.wx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.ehome.dts.wx.common.entity.CommonModel;


/**
 * 绑定用户
 * @author yangxi
 */
@Entity
@Table(name="user_bind")
@DynamicUpdate(true)
public class UserBind extends CommonModel implements Serializable{
	private static final long serialVersionUID = 2785899739135776813L;
	private long userId;
	private String openid;
	private String phoneNumber;
	@Transient
	private String variCode;//验证码
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVariCode() {
		return variCode;
	}
	public void setVariCode(String variCode) {
		this.variCode = variCode;
	}
}
