package com.ehome.dts.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.Page;
import com.ehome.dts.wx.common.bean.Strings;
import com.ehome.dts.wx.common.bean.WatchShop;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.HttpUtil;
import com.ehome.dts.wx.entity.UserBind;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.string.StringUtil;

import io.swagger.annotations.Api;

/**
 * @ClassName: ShopController  
 * @Description: 店铺相关接口
 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>  
 * @date 2016年12月22日 下午4:31:23
 */
@RestController
@RequestMapping("/userWatchShop")
@Api(value="关注店铺",description="关注店铺相关接口")
public class UserWatchShopController {
	private static final Logger logger = Logger.getLogger(UserWatchShopController.class);
	@Autowired
	private HttpUtil httputil;
	@Autowired
	private UserBindService userBindService;
	// 服务地址
	@Value("${serviceServerName}")
	private String serviceServerName;

	/**
	 * @Title  getWatchList 
	 * @date 2016年12月22日 下午4:51:52 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public List<WatchShop> getWatchList(@RequestBody Page page,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
		try {
			
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		logger.info("openId = " + openId);
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		long userId = userBind.getUserId();
    		logger.info(page);
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("page", page.getPage()+"");
    		nvpsMap.put("size", page.getSize()+"");
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		String url = serviceServerName+"/userWatchShop/list.action";
    		return httputil.getServiceArray(header, url, nvpsMap, WatchShop.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
	}
	
	/**
	 * @Title  addWatch 
	 * @date 2016年12月23日 上午9:57:13 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  增加店铺关注
	 * @param shopId
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws LogicException
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Boolean addWatch(@RequestParam("shopId") long shopId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
		try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		long userId = userBind.getUserId();
    		
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		header.put("shopId", shopId+"");
    		String url = serviceServerName+"/userWatchShop/add.action";
    		return httputil.postService(header, url, nvpsMap, Boolean.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
	}
	
	
	/**
	 * @Title  delWatch 
	 * @date 2016年12月23日 上午9:57:13 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  取消关注
	 * @param shopIds  逗号分隔
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws LogicException
	 */
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public Boolean delWatch(@RequestParam("shopIds") String shopIds, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
		try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		long userId = userBind.getUserId();
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("shopIds", shopIds);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		String url = serviceServerName+"/userWatchShop/del.action";
    		logger.info("=====" + url);
    		return httputil.postService(header, url, nvpsMap, Boolean.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
	}
	
	/**
	 * @Title  getWatchShop 
	 * @date 2016年12月23日 上午10:02:11 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  获取店铺详情
	 * @param shopId
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws LogicException
	 */
	@RequestMapping(value="/info/{id}", method=RequestMethod.GET)
	public WatchShop getWatchShop(@PathVariable("id") long shopId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
		try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		long userId = userBind.getUserId();
    		
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		header.put("shopId", shopId+"");
    		String url = serviceServerName+"/userWatchShop/info/" + shopId;
    		return httputil.getService(header, url, nvpsMap, WatchShop.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
	}
	
	/**
	 * @Title  getWatchList 
	 * @date 2016年12月22日 下午4:51:52 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public List<WatchShop> search(@RequestParam("key") String key, @RequestBody Page page,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
		try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		long userId = userBind.getUserId();
    		logger.info(page);
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("page", page.getPage()+"");
    		nvpsMap.put("size", page.getSize()+"");
    		nvpsMap.put("key", key);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		String url = serviceServerName+"/userWatchShop/search";
    		return httputil.getServiceArray(header, url, nvpsMap, WatchShop.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
	}
	
	
}
