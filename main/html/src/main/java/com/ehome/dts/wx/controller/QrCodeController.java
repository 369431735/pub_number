package com.ehome.dts.wx.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ehome.dts.wx.common.util.QrCodeUtil;
import com.ehome.dts.wx.service.TokenService;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.string.StringUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/qrcode")
@Api(value="二维码")
public class QrCodeController {
	@Value("${weixinAppId}")
	private String weixinAppId;
	@Value("${weixinServerName}")
	private String weixinServerName;
	@Value("${appSecret}")
	private String appSecret;
    private static final Logger logger = Logger.getLogger(QrCodeController.class);
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserBindService userBindService;
    
    
    @ResponseBody
    @RequestMapping(value="",method=RequestMethod.GET)
    public void qrcode(HttpServletRequest request,HttpServletResponse response) {
    	try {
    		String agent = request.getHeader("user-agent");
    		if(StringUtil.isNotBlank(agent) && agent.contains("MicroMessenger")){
//    			微信逻辑
    			String qrcode = request.getParameter("code");
    			
    			logger.info("qrcode is : " + qrcode );
    			int type = QrCodeUtil.getType(qrcode);
    			logger.info("type ===="+ type);
    			if(type == 1){
//    				商品
    				int commodityId = QrCodeUtil.getCommodityId(qrcode);
    				
    				String url = weixinServerName+"/web/commodityDetail/"+commodityId;
    				logger.info("redirect ulr is :"+url);
    				response.sendRedirect(url);// 跳转到要访问的地址
    			}
    		}else {
//				普通浏览器逻辑
    			logger.info("===================普通浏览器："+agent);
//    			微信逻辑
    			String qrcode = request.getParameter("code");
    			
    			logger.info("qrcode is : " + qrcode );
    			int type = QrCodeUtil.getType(qrcode);
    			logger.info("type ===="+ type);
    			if(type == 1){
//    				商品
    				int commodityId = QrCodeUtil.getCommodityId(qrcode);
    				
    				String url = weixinServerName+"/html/commodityDetail/"+commodityId;
    				logger.info("redirect ulr is :"+url);
    				response.sendRedirect(url);// 跳转到要访问的地址
    			}
			}
    		
    	} catch (IOException e) {
    		logger.error("什么鬼。。。。");
    		e.printStackTrace();
    	}
    }
    
}