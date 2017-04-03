package com.ehome.dts.wx.controller;

import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.service.TokenService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
@Api(value="验证相关")
public class TokenController {
    private static final Logger logger = Logger.getLogger(TokenController.class);
    @Autowired
    private TokenService tokenService;
     

    @RequestMapping(method=RequestMethod.GET)
    public String wechatValidate(HttpServletRequest request,HttpServletResponse response) {
    	logger.info("调用了wechatValidate");
    	String signature = request.getParameter("signature");
    	String timestamp = request.getParameter("timestamp");
    	String nonce = request.getParameter("nonce");
    	String echostr = request.getParameter("echostr");
    	boolean valiResult = tokenService.validate(signature, timestamp, nonce);
    	if(valiResult){
    		return echostr;
    	}
    	return "";
    }
    

    @RequestMapping(value="/html/**",method=RequestMethod.GET)
    public ModelAndView html() throws LogicException{
    	try {
    		return new ModelAndView("index");
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
    /**
     * 接收微信服务器发来的消息
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param msgXml
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    public String receiveMessage(@RequestBody String msgXml,HttpServletRequest request,HttpServletResponse response) {
    	logger.info("调用了receiveMessage！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
    	String signature = request.getParameter("signature");
    	String timestamp = request.getParameter("timestamp");
    	String nonce = request.getParameter("nonce");
    	String result = tokenService.getMessage(signature,timestamp,nonce,msgXml);
    	return result;
    }
    
    
}