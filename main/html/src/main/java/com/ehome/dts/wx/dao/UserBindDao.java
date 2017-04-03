package com.ehome.dts.wx.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ehome.dts.wx.entity.UserBind;

public interface UserBindDao extends PagingAndSortingRepository<UserBind, Long> {
	public UserBind findTopByOpenid(String openId);
	
	public UserBind getByUserIdAndDeletedFalse(long userId);
	
	public UserBind getByPhoneNumber(String pnoneNumber);
	
}
