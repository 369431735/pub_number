package com.ehome.dts.wx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ehome.dts.wx.common.bean.User;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.HttpUtil;
import com.ehome.dts.wx.dao.UserBindDao;
import com.ehome.dts.wx.entity.UserBind;

@Component
@Transactional
public class UserBindService {
	@Autowired
	private UserBindDao userBindDao;
	@Autowired
	private HttpUtil httputil;
	
	@Value("${serviceServerName}")
	private String serviceServerName;

	public List<UserBind> findAll(){
		return (List<UserBind>) userBindDao.findAll();
	}
	
	public UserBind getByOpenId(String openId){
		return userBindDao.findTopByOpenid(openId);
	}
	
	public void add(UserBind userBind){
		long curTime = System.currentTimeMillis();
		userBind.setCreateTime(curTime);
		userBind.setUpdateTime(curTime);
		userBindDao.save(userBind);
	}
	
	public UserBind getByPhoneNumber(String phoneNumber){
		return userBindDao.getByPhoneNumber(phoneNumber);
	}
	
	public UserBind getByUserId(long userId){
		return userBindDao.getByUserIdAndDeletedFalse(userId);
	}

	public void saveOrUpdate(UserBind userBind) throws LogicException {
		try {
			//验证登陆
			String phoneNumber = userBind.getPhoneNumber();
			String variCode = userBind.getVariCode();
			String url = serviceServerName+"/user/signUpAndIn.action";
			Map<String, String> header = new HashMap<String, String>();
			Map<String, String> nvpsMap = new HashMap<String, String>();
			nvpsMap.put("phoneNumber", phoneNumber);
			nvpsMap.put("variCode", variCode);
			
			User userRes = httputil.postService(header, url, nvpsMap,User.class);
			if(userRes == null){
				throw new LogicException("调用接口异常："+url);
			}
			String openId = userBind.getOpenid();
			UserBind existUserBind = getByOpenId(openId);
			if(existUserBind == null || existUserBind.isDeleted()){
				throw new LogicException("userbind 丢失了");
			}
			existUserBind.setUpdateTime(System.currentTimeMillis());
			//设置userId
			existUserBind.setPhoneNumber(phoneNumber);
			existUserBind.setUserId(userRes.getModelId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("服务器逻辑错误");
		}
	}
	
	/**
	 * @Title  updateUserbind 
	 * @date 2017年1月7日 下午8:12:30 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  更新用户绑定
	 * @param userBind
	 * @return
	 */
	public UserBind updateUserbind(UserBind userBind) {
		return userBindDao.save(userBind);
	}
	
}
