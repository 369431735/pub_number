package com.ehome.dts.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.Page;
import com.ehome.dts.wx.common.bean.Strings;
import com.ehome.dts.wx.common.bean.result.CommodityTrack;
import com.ehome.dts.wx.common.bean.result.UserCommodity;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.HttpUtil;
import com.ehome.dts.wx.entity.UserBind;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.string.StringUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/userCommodity")
@Api(value="关注商品",description="关注商品相关接口")
public class UserCommodityController {
    private static final Logger logger = Logger.getLogger(UserCommodityController.class);
    @Autowired
    private UserBindService userBindService;
    @Autowired
    private HttpUtil httputil;
    
    @Value("${serviceServerName}")
	private String serviceServerName;
     
    /**
     * 根据商品id获取关注
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param id 商品id
     * @param response
     * @param session
     * @return UserCommodity
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/commodityId/{id}",method=RequestMethod.GET)
    public UserCommodity getUserCommodityByCommodityId(@PathVariable("id") int id ,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		logger.info("openId =========="+openId);
    		boolean footprinted = false;
    		Map<String, String> nvps = new HashMap<String, String>();
    		nvps.put("commodityId", id+"");
    		nvps.put("openId", openId);
    		Map<String, String> header = new HashMap<String, String>();
    		if(StringUtil.isNotBlank(openId)){
    			UserBind userBind = userBindService.getByOpenId(openId);
    			if(userBind != null && (!userBind.isDeleted())){
    				footprinted = true;
    				header.put("userId", userBind.getUserId()+"");
    				nvps.put("footprinted", "1");
    			}
    		}
    		UserCommodity userCommodity = httputil.postService(header,serviceServerName+"/userCommodity/getUserCommodityByCommodityId.action", nvps,UserCommodity.class);
			userCommodity.setFootprinted(footprinted);
    		return userCommodity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("有异常");
		}
    }
    /**
     * 获取关注详情
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param id
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/userCommodityId/{id}",method=RequestMethod.GET)
    public UserCommodity getUserCommodityDetail(@PathVariable("id") int id ,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("userCommodityId", id+"");
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/userCommodityDetail.action";
    		UserCommodity userCommodity = httputil.postService(header, url, nvpsMap, UserCommodity.class);
    		userCommodity.setFootprinted(true);
    		return userCommodity;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 关注列表
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param page Page对象，注入请求页数（从0开始）和每页条数
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/userCommodities",method=RequestMethod.POST)
    public List<UserCommodity> userCommodities(@RequestBody Page page,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		logger.info(page);
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("page", page.getPage()+"");
    		nvpsMap.put("size", page.getSize()+"");
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/userWechartCommodities.action";
    		return httputil.postServiceArray(header, url, nvpsMap, UserCommodity.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 足迹列表
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param page
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/commodityTracks",method=RequestMethod.POST)
    public List<CommodityTrack> commodityTracks(@RequestBody Page page,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("page", page.getPage()+"");
    		nvpsMap.put("size", page.getSize()+"");
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/commodityTracks.action";
    		return httputil.postServiceArray(header, url, nvpsMap, CommodityTrack.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 关注商品
     * 普通商品注入：commodityId、skuId ; 套餐商品注入commodityId
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param userCommodity
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/addUserCommodity",method=RequestMethod.POST)
    public UserCommodity addUserCommodity(@RequestBody UserCommodity userCommodity,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		userCommodity.setType(UserCommodity.TYPE_SHOP);
    		userCommodity.setUserId(Integer.parseInt(userBind.getUserId()+""));
    		userCommodity.setOpenId(userBind.getOpenid());
    		nvpsMap.put("userCommodityJson", JSON.toJSONString(userCommodity));
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/addUserCommodity.action";
    		return httputil.postService(header, url, nvpsMap, UserCommodity.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 修改关注询价 必须注入price、modelId
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param userCommodity
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/updatePrice",method=RequestMethod.POST)
    public UserCommodity updatePrice(@RequestBody UserCommodity userCommodity,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		userCommodity.setUserId(Integer.parseInt(userBind.getUserId()+""));
    		userCommodity.setOpenId(userBind.getOpenid());
    		nvpsMap.put("userCommodityJson", JSON.toJSONString(userCommodity));
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/updatePrice.action";
    		return httputil.postService(header, url, nvpsMap, UserCommodity.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 修改型号 必须注入modelId、skuId
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param userCommodity
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/updateSkuId",method=RequestMethod.POST)
    public UserCommodity updateSkuId(@RequestBody UserCommodity userCommodity,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		userCommodity.setUserId(Integer.parseInt(userBind.getUserId()+""));
    		userCommodity.setOpenId(userBind.getOpenid());
    		nvpsMap.put("userCommodityJson", JSON.toJSONString(userCommodity));
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/updateSkuId.action";
    		return httputil.postService(header, url, nvpsMap, UserCommodity.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 批量删除关注
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param userCommodities
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/removeUserCommodities",method=RequestMethod.POST)
    public List<UserCommodity> removeUserCommodities(@RequestBody List<UserCommodity> userCommodities,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("userCommodityJson", JSON.toJSONString(userCommodities));
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/removeUserCommodities.action";
    		List<UserCommodity> result = httputil.postServiceArray(header, url, nvpsMap,UserCommodity.class);
    		return result;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    @ResponseBody
    @RequestMapping(value="/confirmUpdatePrice/{id}",method=RequestMethod.POST)
    public void confirmUpdatePrice(@PathVariable("id") int id,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("userCommodityId", id+"");
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/confirmUpdatePrice.action";
    		httputil.postService(header, url, nvpsMap);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * 
     * @Title  searchCommdities 
     * @date 2016年12月21日 下午5:16:17 
     * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
     * @Description  搜索关注商品
     * @param page
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/searchUserWechartCommdities",method=RequestMethod.POST)
    public List<UserCommodity> searchCommdities(@RequestParam("key") String key, @RequestBody Page page,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		long userId = 0;
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null != userBind){
    			userId = userBind.getUserId();
    		}
    		logger.info(page);
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("openId", openId);
    		nvpsMap.put("page", page.getPage()+"");
    		nvpsMap.put("size", page.getSize()+"");
    		nvpsMap.put("key", key);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userId+"");
    		String url = serviceServerName+"/userCommodity/searchUserWechartCommdities.action";
    		return httputil.postServiceArray(header, url, nvpsMap, UserCommodity.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
    /**
     * @Title  removeUserCommodities 
     * @date 2016年12月23日 上午11:04:05 
     * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
     * @Description  批量删除足迹
     * @param userCommodities
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/delcommodityTracks",method=RequestMethod.POST)
    public Boolean delcommodityTracks(@RequestParam("ids") String ids,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到openId");
    		}
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("ids", ids);
    		nvpsMap.put("openId", openId);
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/userCommodity/delcommodityTracks.action";
    		return  httputil.postService(header, url, nvpsMap, Boolean.class);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("有异常");
    	} 
    }
    
}