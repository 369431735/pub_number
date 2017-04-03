package com.ehome.dts.wx.controller;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.Strings;
import com.ehome.dts.wx.common.bean.User;
import com.ehome.dts.wx.common.bean.wrbean.AllUser;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.AccessTokenUtils;
import com.ehome.dts.wx.common.util.HttpUtil;
import com.ehome.dts.wx.common.util.MenuUtils;
import com.ehome.dts.wx.entity.UserBind;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.net.HttpClientUtil;
import com.ehome.util.util.string.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/user")
@Api(value="用户",description="账户管理相关接口")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserBindService userBindService;
    @Autowired
    private AccessTokenUtils accessTokenUtils;
    @Autowired
    private HttpUtil httputil;
    @Value("${serviceServerName}")
	private String serviceServerName;
    @Autowired
    private MenuUtils menuUtils;
    
     
//    @ResponseBody
//    @RequestMapping(value="/createMenu",method=RequestMethod.GET)
//    public void createMenu() {
//    	menuUtils.createCommMenu();
//    }
    
    /**
     * 获取所有关注的微信公众号，注入到本地数据库
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/getAllUser",method=RequestMethod.GET)
    public AllUser getAllUser(HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessTokenUtils.getSavedAccess_token();
    		String result = HttpClientUtil.get(url);
    		logger.info("result=============="+result);
    		AllUser allUser = JSON.parseObject(result, AllUser.class);
    		List<String> opList = allUser.getData().getOpenid();
    		List<UserBind> all = userBindService.findAll();
    		Set<String> now = new HashSet<String>();
    		for (UserBind userBind : all) {
				now.add(userBind.getOpenid());
			}
    		for (String string : opList) {
    			if(!now.contains(string)){
    				UserBind userBind = new UserBind();
    				userBind.setOpenid(string);
    				userBindService.add(userBind);
    			}
			}
    		
    		return allUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("有异常");
		} 
    }
    
    @ResponseBody
    @RequestMapping(value="/bind",method=RequestMethod.POST)
    public String bindUser(@RequestBody UserBind userBind,HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		logger.info(userBind.toString());
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		logger.info("openId is : "+openId);
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到用户openId");
    		}
    		userBind.setOpenid(openId);
    		userBindService.saveOrUpdate(userBind);
    		String url = session.getAttribute(Strings.CALL_BACK_URL)+"";
    		logger.info("url is :"+url);
    		return url+".html";
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("验证码错误");
    	} 
    }
    
    /**
     * 绑定用户获取验证码
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param phoneNumber
     * @param request
     * @param response
     * @param session
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/code",method=RequestMethod.POST)
    public void getVariCode(@RequestBody String phoneNumber,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException {
    	String openId = session.getAttribute(Strings.OPEN_ID)+"";
    	if(StringUtil.isBlank(openId)){
    		throw new LogicException("没有获取到用户openId");
    	}
    	
    	UserBind existUserBindOpen = userBindService.getByOpenId(openId);
    	if(existUserBindOpen != null && StringUtil.isNotBlank(existUserBindOpen.getPhoneNumber())){
    		throw new LogicException("业务逻辑错误，该用户已经绑定："+openId);
    	}
    	
    	UserBind existUserBindPhone = userBindService.getByPhoneNumber(phoneNumber);
    	if(existUserBindPhone != null){
    		throw new LogicException("该手机号已绑定另外的微信");
    	}
    	
    	Map<String, String> header = new HashMap<String, String>();
    	Map<String, String> nvps = new HashMap<String, String>();
    	nvps.put("phoneNumber", phoneNumber);
    	httputil.postService(header, serviceServerName+"/user/getVariCodeByPhonenumber.action", nvps);
    }
    
    /**
     * @Title  getUserInfo 
     * @date 2016年12月22日 下午2:36:30 
     * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
     * @Description  获取用户信息, 当user.modelId=0 表示未绑定
     * @param session
     * @return
     * @throws LogicException
     */
    @ApiOperation(value="获取用户信", notes="当user.modelId=0表示未绑定, 大于0表示数据")
    @ResponseBody
    @RequestMapping(value="/info", method=RequestMethod.GET)
    public User getUserInfo(HttpSession session) throws LogicException {
    	User user = new User();
//    	user.setImageUrl();
    	user.setModelId(0); // 未绑定用户 id为0
    	String openId = session.getAttribute(Strings.OPEN_ID)+"";
    	if(StringUtil.isBlank(openId)){
    		throw new LogicException("没有获取到用户openId");
    	}
    	
    	UserBind userBind = userBindService.getByOpenId(openId);
    	if(userBind == null || userBind.isDeleted() || userBind.getUserId() <= 0){
			logger.info("该用户没绑定："+openId);
			return user;
		}
    	
    	String url = serviceServerName+"/user/info/" + userBind.getUserId() ;
    	try {
    		user = httputil.getService(null, url, null, User.class);
		} catch (Exception e) {
			logger.error("发生错误", e);
		}
    	return user;
    }
    
    @ApiOperation(value="解绑用户", notes="解绑当前用户")
    @ResponseBody
    @RequestMapping(value="/unbind",method=RequestMethod.POST)
    public Boolean unBindUser(HttpServletResponse response,HttpSession session) throws LogicException {
    	try {
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		logger.info("openId is : "+openId);
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("没有获取到用户openId");
    		}

    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(null == userBind){
    			throw new LogicException("该用户没有关注公众号");
    		}
    		
    		userBind.setUserId(0);
    		userBind.setPhoneNumber("");
    		userBindService.updateUserbind(userBind);
    		return true;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("验证码错误");
    	} 
    }
    
    
    @ApiOperation(value="修改用户信息", notes="修改用户资料")
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public User update(@ApiParam(required=false,name="nickName", value="用户昵称") @RequestParam(value="nickName", required=false) String nickName,
    		@ApiParam(required=false,name="sex", value="用户性别，1 男， 0 女， -1 保密") @RequestParam(value="sex", required=false, defaultValue="-100") int sex,
    		@ApiParam(required=false,name="imgUrl", value="用户头像") @RequestParam(value="imgUrl", required=false) String imgUrl,
    		HttpServletRequest request,HttpSession session) throws LogicException {
    	String openId = session.getAttribute(Strings.OPEN_ID)+"";
		logger.info("openId is : "+openId);
		if(StringUtil.isBlank(openId)){
			throw new LogicException("没有获取到用户openId");
		}

		UserBind userBind = userBindService.getByOpenId(openId);
		if(null == userBind){
			throw new LogicException("该用户没有关注公众号");
		}
		
		if (StringUtil.isBlank(imgUrl) && StringUtil.isBlank(nickName) && StringUtil.isBlank(imgUrl)) {
			throw new LogicException("参数错误");
		}
		
		long userId = userBind.getUserId();
    	Map<String, String> header = new HashMap<String, String>();
    	Map<String, String> nvps = new HashMap<String, String>();
    	nvps.put("sex", sex + "");
    	nvps.put("nickName", nickName);
//    	nvps.put("imgUrl", imgUrl);
    	User user = httputil.postService(header, serviceServerName + "/user/update/" +userId , nvps, User.class);
    	return user;
    }
}