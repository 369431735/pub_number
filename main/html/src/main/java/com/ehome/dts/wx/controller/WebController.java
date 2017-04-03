package com.ehome.dts.wx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.AutoWebParams;
import com.ehome.dts.wx.common.bean.JsConfig;
import com.ehome.dts.wx.common.bean.Strings;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.JsApiTicketUtils;
import com.ehome.dts.wx.common.util.MenuUtils;
import com.ehome.dts.wx.common.util.wx.SHA1;
import com.ehome.dts.wx.entity.UserBind;
import com.ehome.dts.wx.service.TokenService;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.net.HttpClientUtil;
import com.ehome.util.util.string.StringUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/web")
@Api(value="web相关配置等")
public class WebController {
	@Autowired
	private JsApiTicketUtils jsApiTicketUtils;
	@Value("${weixinAppId}")
	private String weixinAppId;
	@Value("${weixinServerName}")
	private String weixinServerName;
	@Value("${appSecret}")
	private String appSecret;
    private static final Logger logger = Logger.getLogger(WebController.class);
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserBindService userBindService;
    
    @Autowired 
    private MenuUtils menuUtils;
    
    @ResponseBody
    @RequestMapping(value="/orderList",method=RequestMethod.GET)
    public void getOrderListUrl(HttpServletRequest request,HttpServletResponse response) {
    	try {
    		String state = "orderList";
    		String url = getRedirectUrl(state);
            logger.info("redirect url :"+url);
            response.sendRedirect(url);// 跳转到要访问的地址
		} catch (IOException e) {
			logger.error("什么鬼。。。。");
			e.printStackTrace();
		}
    }
    
    @ResponseBody
    @RequestMapping(value="/userCommodities",method=RequestMethod.GET)
    public void userCommodities(HttpServletRequest request,HttpServletResponse response) {
    	try {
    		String state = "userCommodities";
    		String url = getRedirectUrl(state);
    		logger.info("redirect url :"+url);
    		response.sendRedirect(url);// 跳转到要访问的地址
    	} catch (IOException e) {
    		logger.error("什么鬼。。。。");
    		e.printStackTrace();
    	}
    }
    
    @ResponseBody
    @RequestMapping(value="/personalCenter",method=RequestMethod.GET)
    public void personalCenter(HttpServletRequest request,HttpServletResponse response) {
    	try {
    		String state = "personalCenter";
    		String url = getRedirectUrl(state);
    		logger.info("redirect url :"+url);
    		response.sendRedirect(url);// 跳转到要访问的地址
    	} catch (IOException e) {
    		logger.error("什么鬼。。。。");
    		e.printStackTrace();
    	}
    }
    
//    @ResponseBody
//    @RequestMapping(value="/{state}",method=RequestMethod.GET)
//    public void getTokenUrl(@PathVariable("state") String state,HttpServletRequest request,HttpServletResponse response) {
//    	try {
//    		/**
//             * 第一步：用户同意授权，获取code:https://open.weixin.qq.com/connect/oauth2/authorize
//             * ?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE
//             * &state=STATE#wechat_redirect
//             */
//            String redirect_uri = weixinServerName+"/web/accessToken";// 目标访问地址
//            redirect_uri = URLEncoder.encode(redirect_uri, "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
//            // 按照文档要求拼接访问地址
//            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
//                    + weixinAppId
//                    + "&redirect_uri="
//                    + redirect_uri
//                    + "&response_type=code&scope=snsapi_base&state="+state+"#wechat_redirect";
//            response.sendRedirect(url);// 跳转到要访问的地址
//		} catch (IOException e) {
//			logger.error("什么鬼。。。。");
//			e.printStackTrace();
//		}
//    }
    
    /**
     * 获取jssdk需要的配置信息
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param url 当前页的url
     * @param request
     * @param response
     * @return
     * @throws LogicException 
     */
    @ResponseBody
    @RequestMapping(value="/jsconfig",method=RequestMethod.GET)
    public JsConfig getTokenUrl(HttpServletRequest request,HttpServletResponse response) throws LogicException {
    	try {
    		logger.info("jsconfig");
    		String url = request.getParameter("url");
    		JsConfig jsConfig = new JsConfig();
    		String nonceStr = StringUtil.getUUID();
    		long timestamp = System.currentTimeMillis()/1000;
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("noncestr", nonceStr);
    		String allUrl = weixinServerName+url;
    		map.put("url", allUrl);
    		map.put("jsapi_ticket", jsApiTicketUtils.getSavedJsApiTicket());
    		map.put("timestamp", timestamp+"");
    		String signature = SHA1.getSH1(map);
    		
    		jsConfig.setAppId(weixinAppId);
    		jsConfig.setNonceStr(nonceStr);
    		jsConfig.setSignature(signature);
    		jsConfig.setUrl(allUrl);
    		jsConfig.setTimestamp(timestamp);
    		return jsConfig;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序异常");
    	}
    }
    
    @ResponseBody
    @RequestMapping(value="/commodityDetail/{id}",method=RequestMethod.GET)
    public void getCommodityDetailUrl(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response) {
    	try {
    		String state = "commodityDetail/"+id;
    		String url = getRedirectUrl(state);
    		logger.info("redirect url :"+url);
    		response.sendRedirect(url);// 跳转到要访问的地址
    	} catch (IOException e) {
    		logger.error("什么鬼。。。。");
    		e.printStackTrace();
    	}
    }

	private String getRedirectUrl(String state)
			throws UnsupportedEncodingException {
		/**
		 * 第一步：用户同意授权，获取code:https://open.weixin.qq.com/connect/oauth2/authorize
		 * ?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE
		 * &state=STATE#wechat_redirect
		 */
		String redirect_uri = weixinServerName+"/web/accessToken";// 目标访问地址
		redirect_uri = URLEncoder.encode(redirect_uri, "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
		// 按照文档要求拼接访问地址
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
		        + weixinAppId
		        + "&redirect_uri="
		        + redirect_uri
		        + "&response_type=code&scope=snsapi_base&state="+state+"#wechat_redirect";
		logger.info("getRedirectUrl ====" + url);
		return url;
	}
    
    @ResponseBody
    @RequestMapping(value="/accessToken",method=RequestMethod.GET)
    public void getToken(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	try {
    		String code = request.getParameter("code");
    		String state = request.getParameter("state");
    		if (code != null) {
    	        // 拼接请求地址
    	        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
    	                + "appid=" + weixinAppId + "&secret="
    	                + appSecret
    	                + "&code=" + code
    	                + "&grant_type=authorization_code";
    	        logger.info("get token url is :"+url);
    	        String json = HttpClientUtil.get(url);
    	        logger.info("return json is ====="+json);
    	        AutoWebParams autoWebParams = JSON.parseObject(json, AutoWebParams.class);
    	        
    	        // 设置session
    	        String openId = autoWebParams.getOpenid();
    	        session.setAttribute(Strings.OPEN_ID, openId);
    	        
    	        UserBind userBind = userBindService.getByOpenId(openId);
    	        
    	        if("orderList".equals(state) && (userBind == null || StringUtil.isBlank(userBind.getPhoneNumber()))){
    	        	session.setAttribute(Strings.CALL_BACK_URL, state);
    	        	response.sendRedirect(weixinServerName+"/html/login");
    	        	return;
    	        }
    	        
    	        String redirect_uri = weixinServerName+"/html/"+state;
    	        logger.info("redirect url :"+redirect_uri);
    	        response.sendRedirect(redirect_uri);
    	    }
    	} catch (IOException e) {
    		logger.error("什么鬼。。。。");
    		e.printStackTrace();
    	}
    }
    
    @ResponseBody
    @RequestMapping(value="/createMenu",method=RequestMethod.GET)
    public String createMenu() {
    	menuUtils.createCommMenu();
    	return "success";
    }
    
}