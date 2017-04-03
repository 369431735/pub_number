package com.ehome.dts.wx.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.Backlog;
import com.ehome.dts.wx.common.bean.Strings;
import com.ehome.dts.wx.common.bean.WechartOrderChange;
import com.ehome.dts.wx.common.bean.result.HisCommodity;
import com.ehome.dts.wx.common.bean.result.OrderAct;
import com.ehome.dts.wx.common.bean.result.OrderPic;
import com.ehome.dts.wx.common.bean.result.OrderTime;
import com.ehome.dts.wx.common.bean.result.PayAmount;
import com.ehome.dts.wx.common.bean.result.ReturnSaleOrder;
import com.ehome.dts.wx.common.bean.result.SaleItemCommodity;
import com.ehome.dts.wx.common.bean.result.SaleOrder;
import com.ehome.dts.wx.common.bean.result.Shop;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.common.util.HttpUtil;
import com.ehome.dts.wx.common.util.OrderActUtil;
import com.ehome.dts.wx.common.util.TemplateUtil;
import com.ehome.dts.wx.entity.UserBind;
import com.ehome.dts.wx.service.UserBindService;
import com.ehome.util.util.string.NumberUtil;
import com.ehome.util.util.string.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/orders")
@Api(value="我的订单",description="我的订单相关接口")
@EnableSwagger2
public class OrderController {
    private static final Logger logger = Logger.getLogger(OrderController.class);
    @Value("${serviceServerName}")
	private String serviceServerName;
    @Value("${weixinServerName}")
    private String weixinServerName;
//    @Autowired
//    private TokenService tokenService;
    @Autowired
    private UserBindService userBindService;
    @Autowired
    private TemplateUtil templateUtil;
    @Autowired
    private HttpUtil httputil;
     
    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @ApiOperation(value="获取订单", notes="获取当前用户的订单记录")
    public List<SaleOrder> getOrders(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		logger.info("调用了OrderController");
    		String openId = getOpenIdFromSession(session);
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(userBind == null || userBind.isDeleted() || userBind.getUserId() <= 0){
    			logger.info("该用户没绑定："+openId);
    			session.setAttribute(Strings.CALL_BACK_URL, "/orders");
    			response.sendRedirect(weixinServerName+"/html/login");
    			return null;
    		}
//    		UserBind userBind = new UserBind();
//    		userBind.setUserId(4);
    		
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		String url = serviceServerName+"/saleOrder/getAllUserSelfOrder.action";
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("userId", userBind.getUserId()+"");
    		
    		List<SaleOrder> saleOrders = httputil.postServiceArray(header, url, nvpsMap, SaleOrder.class);
    		Collections.sort(saleOrders, new Comparator<SaleOrder>() {
				@Override
				public int compare(SaleOrder o1, SaleOrder o2) {
					int res = 0;
					if(o2.getPlaceOrderTime() > o1.getPlaceOrderTime()){
						res = 1;
					}else {
						res = -1;
					}
					return res;
				}
			});
    		return saleOrders;
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("程序错误！");
		}
    }
    
    
    /**
     * @Title  getOrderDetail 
     * @date 2016年12月21日 下午3:19:07 
     * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
     * @Description  获取订单详情
     * @param request
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
    public SaleOrder getOrderDetail(@PathVariable("id") long orderId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		// TODO 统一管理
    		logger.info("调用了OrderController");
    		//获取openId
    		String openId = session.getAttribute(Strings.OPEN_ID)+"";
    		if(StringUtil.isBlank(openId)){
    			throw new LogicException("未获取到openId");
    		}
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(userBind == null || userBind.getUserId() <= 0){
    			logger.info("该用户没绑定："+openId);
    			session.setAttribute(Strings.CALL_BACK_URL, "/orders");
    			response.sendRedirect(weixinServerName+"/html/login");
    			return null;
    		}
//    		long orderId = Long.parseLong(request.getParameter("orderId"));
    		
    		SaleOrder saleOrder = getSaleOrderDetail(orderId);
    		return saleOrder;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
    /**
     * @Title  getSaleOrderDetail 
     * @date 2017年1月7日 下午9:05:54 
     * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
     * @Description  TODO(这里用一句话描述这个方法的作用) 
     * @param orderId
     * @return
     * @throws Exception
     */
	private SaleOrder getSaleOrderDetail(long orderId) throws Exception {
		Map<String, String> header = new HashMap<String, String>();
		Map<String, String> nvp = new HashMap<String, String>();
		nvp.put("orderId", orderId+"");
		SaleOrder saleOrder = (SaleOrder) httputil.postService(header,serviceServerName+"/saleOrder/getSaleOrderDetail.action", nvp,SaleOrder.class);
		return saleOrder;
	}
    
    @RequestMapping(value="/backlog",method=RequestMethod.POST)
    public void getOrderDetail(@RequestBody WechartOrderChange wechartOrderChange) throws LogicException{
    	try {
    		int userId = wechartOrderChange.getSaleOrder().getCustomerUserId();
    		logger.info("userId ====="+userId);
    		UserBind userBind = userBindService.getByUserId(userId);
    		if(userBind == null){
    			logger.info("该用户没有绑定微信：userId="+userId);
    			return;
    		}
    		Backlog backlog = wechartOrderChange.getMessage().getBacklog();
    		int type = backlog.getType();
    		String state = "";
    		if(Backlog.TYPE_VIEW_ORDER_PIC == type || Backlog.TYPE_VIEW_PAYAMOUNT == type){
    			return;
    		}
    		if(Backlog.TYPE_NEW_ORDER == type ){
    			state = "confirmOrderDetail";
    		}
    		if(Backlog.TYPE_CONFIRM_RETURNORDER == type || Backlog.TYPE_NEW_RETURNORDER == type){
    			state = "confirmReturn";
    		}
    		if(Backlog.TYPE_CONFIRM_UPDATEORDER == type){
    			state = "orderCommodity";
    		}
    		if(Backlog.TYPE_VIEW_ADDRESS == type){
    			state = "orderInfo";
    		}
    		if(Backlog.TYPE_VIEW_ORDER_TIME == type){
    			state = "orderState";
    		}
    		if(!StringUtil.isBlank(state)){
    			String url = weixinServerName+"/html/"+state+"/"+backlog.getModelId();
    			logger.info("backlog Url is ："+url);
    			templateUtil.setUrl(url);
    		}
    		templateUtil.setTouser(userBind.getOpenid());
    		SaleOrder saleOrder = wechartOrderChange.getSaleOrder();
    		templateUtil.setAmount(saleOrder.getTotalPayAmount());
    		List<String> itemNames = new ArrayList<String>();
    		List<SaleItemCommodity> saleItemCommodities = saleOrder.getCommodityItems();
    		if(saleItemCommodities != null){
    			for (SaleItemCommodity saleItemCommodity : saleItemCommodities) {
    				String name = saleItemCommodity.getHisCommodity().getContent();
					itemNames.add(name);
    			}
    		}
    		templateUtil.setItemNames(itemNames);
    		templateUtil.setOrderNumber(saleOrder.getOrderNumber());
    		templateUtil.setShopName(wechartOrderChange.getMessage().getShop().getName());
    		templateUtil.setTitle(wechartOrderChange.getMessage().getContent());
    		templateUtil.pushWechartMsg();
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
    @RequestMapping(value="/backlogDetailUrl",method=RequestMethod.GET)
    public void backlogDetail(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		String backlogId = request.getParameter("backlogId");
    		String state = request.getParameter("state");
    		session.setAttribute(Strings.BACKLOG_ID, backlogId);
    		response.sendRedirect("/html/"+state);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
    @ResponseBody
    @RequestMapping(value="/backlogDetail/{backlogId}",method=RequestMethod.GET)
    public WechartOrderChange getBacklogDetail(@PathVariable("backlogId") String backlogId,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		logger.info("backlogId is ================"+backlogId);
    		if(StringUtil.isBlank(backlogId)){
    			throw new LogicException("backlogId 为空："+backlogId);
//    			backlogId = 2163+"";
    		}
    		
    		//获取openId
    		//getOpenIdFromSession(session);
    		
//    		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
//    		nvp.add(new BasicNameValuePair());
//    		String gmResultString = HttpClientUtil.get(serviceServerName+"/message/backlogDetail.action", nvp);
//    		logger.info(gmResultString);
//    		GMResult gmResult = JSON.parseObject(gmResultString, GMResult.class);
//    		Backlog backlog = JSON.parseObject(gmResult.getResult()+"", Backlog.class);
    		
    		Map<String, String> nvpsMap = new HashMap<String, String>();
    		nvpsMap.put("backlogId", backlogId);
    		Map<String, String> header = new HashMap<String, String>();
    		
    		Backlog backlog = httputil.postService(header, serviceServerName+"/message/backlogDetail.action", nvpsMap, Backlog.class);
    		
    		if(Backlog.TYPE_VIEW_ORDER_TIME == backlog.getType()){
    			OrderAct orderAct = JSON.parseObject(backlog.getObject()+"", OrderAct.class);
    			String result = OrderActUtil.getChangeJsonString(orderAct.getAfterChange());
    			List<OrderTime> orderTimes = JSON.parseArray(result, OrderTime.class);
    			Collections.sort(orderTimes, new Comparator<OrderTime>() {
    				@Override
    				public int compare(OrderTime o1, OrderTime o2) {
    					if (o1.getState() != o2.getState()) {
    						return o2.getState() - o1.getState();
    					}
    					return NumberUtil.toInt((o1.getValue() - o2.getValue()) + "");
    				}
    			});
    			backlog.setObject(orderTimes);
    		}
    		if(Backlog.TYPE_VIEW_ORDER_PIC == backlog.getType()){
    			OrderAct orderAct = JSON.parseObject(backlog.getObject()+"", OrderAct.class);
    			String result = OrderActUtil.getChangeJsonString(orderAct.getAfterChange());
    			List<OrderPic> orderPics = JSON.parseArray(result, OrderPic.class);
    			backlog.setObject(orderPics);
    		}
    		if(Backlog.TYPE_NEW_RETURNORDER == backlog.getType() || Backlog.TYPE_CONFIRM_RETURNORDER == backlog.getType()){
    			ReturnSaleOrder returnSaleOrder = JSON.parseObject(backlog.getObject()+"", ReturnSaleOrder.class);
    			backlog.setObject(returnSaleOrder);
    		}
    		if(Backlog.TYPE_CONFIRM_UPDATEORDER == backlog.getType()){
    			SaleOrder saleOrder = JSON.parseObject(backlog.getObject()+"", SaleOrder.class);
    			processOrderAmount(saleOrder);
    			backlog.setObject(saleOrder);
    		}
    		int saleOrderId = backlog.getSaleOrderId();
    		SaleOrder saleOrder = getSaleOrderDetail(saleOrderId);
    		WechartOrderChange wechartOrderChange = new WechartOrderChange();
    		wechartOrderChange.setSaleOrder(saleOrder);
    		wechartOrderChange.setBacklog(backlog);
    		return wechartOrderChange;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }



	/**
	 * 验证openId
	 * <a href="xi.yang@i-jia.net">yangxi</a>
	 * @param session
	 * @throws LogicException
	 */
	private String getOpenIdFromSession(HttpSession session) throws LogicException {
		String openId = session.getAttribute(Strings.OPEN_ID)+"";
		logger.info(" openId is :"+openId);
		if(StringUtil.isBlank(openId)){
			throw new LogicException("未获取到openId");
		}
		return openId;
	}
    
    private void processOrderAmount(SaleOrder saleOrder) {
		List<PayAmount> payAmounts = saleOrder.getPayAmounts();
		List<ReturnSaleOrder> relatedRetOrders = saleOrder.getRelatedRetOrders();
		double payAmount = 0f;// 已收款
		double retAmount = 0f;// 退款总金额
		if (relatedRetOrders != null && relatedRetOrders.size() > 0) {
			for (ReturnSaleOrder returnSaleOrder : relatedRetOrders) {
				retAmount = retAmount + returnSaleOrder.getTotalAmount();
			}
		}
		if (payAmounts != null && payAmounts.size() > 0) {
			for (PayAmount temp : payAmounts) {
				payAmount = payAmount + temp.getAmount();
			}
		}
		saleOrder.setTotalReturnAmount(retAmount);
		saleOrder.setTotalPayAmount(saleOrder.getTotalAmount() - retAmount);
		saleOrder.setPayAmount(payAmount);
		saleOrder.setUnPayAmount(saleOrder.getTotalPayAmount() - payAmount);
	}
    
    /**
     * <a href="xi.yang@i-jia.net">yangxi</a>
     * @param backlog modelId,type,state通用，新订单objec要注入homeId
     * @param request
     * @param response
     * @param session
     * @throws LogicException
     */
    @ResponseBody
    @RequestMapping(value="/doBacklog",method=RequestMethod.POST)
    public void doBacklog(@RequestBody Backlog backlog,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		if(backlog.getType() == Backlog.TYPE_NEW_ORDER){
    			backlog.setObject("-9999");
    		}
    		Map<String, String> nvp = new HashMap<String, String>();
    		nvp.put("backlogJson", JSON.toJSONString(backlog));
    		Map<String, String> header = new HashMap<String, String>();
    		httputil.postService(header,serviceServerName+"/message/doBacklog.action", nvp);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
    /**
     * @Title  search 
     * @date 2016年12月21日 下午2:56:54 
     * @author <a href=mailto:xi.yang@i-jia.net>yangxi</a>
     * @Description  搜索
     * @param key    搜索条件：订单编号，商家名称、商品品名、型号
     * @param request
     * @param response
     * @param session
     * @return
     * @throws LogicException
     */
    @RequestMapping(value="/search/{key}",method=RequestMethod.GET)
    public List<SaleOrder> search(@PathVariable("key") String key,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws LogicException{
    	try {
    		String openId = getOpenIdFromSession(session);
    		
    		UserBind userBind = userBindService.getByOpenId(openId);
    		if(userBind == null || userBind.getUserId() <= 0){
    			logger.info("该用户没绑定："+openId);
    			throw new LogicException("该用户没绑定");
    		}
//    		UserBind userBind = new UserBind();
//    		userBind.setUserId(4);
    		
    		Map<String, String> header = new HashMap<String, String>();
    		header.put("userId", userBind.getUserId()+"");
    		Map<String, String> nvp = new HashMap<String, String>();
    		nvp.put("userId", userBind.getUserId()+"");
    		
    		
    		List<SaleOrder> saleOrders = httputil.postServiceArray(header, serviceServerName+"/saleOrder/getAllUserSelfOrder.action", nvp, SaleOrder.class);
    		List<SaleOrder> searchOrders = new ArrayList<SaleOrder>();
    		for (SaleOrder saleOrder : saleOrders) {
    			//
    			// changed by jimmy 
    			// at 2016-12-21
    			//
    			if (saleOrder.getOrderNumber().contains(key)) { // 订单编号
    				searchOrders.add(saleOrder);
					continue;
				}
				Shop shop = saleOrder.getShop();
				if(shop.getName().contains(key)){ // 商家名称
					searchOrders.add(saleOrder);
					continue;
				}
				List<SaleItemCommodity> saleItemCommodities = saleOrder.getCommodityItems();
				for (SaleItemCommodity saleItemCommodity : saleItemCommodities) {
					HisCommodity hisCommodity = saleItemCommodity.getHisCommodity();
					if(hisCommodity == null){
						continue;
					}
					String brandName = hisCommodity.getBrandName(); // 品牌
					String content = hisCommodity.getContent(); // 品名
					String skuName = hisCommodity.getSkuName(); // 型号
					
					if((brandName != null && brandName.contains(key)) || (content != null && content.contains(key)) || (skuName != null && skuName.contains(key))){
						searchOrders.add(saleOrder);
						break;
					}
				}
			}
    		return searchOrders;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new LogicException("程序错误！");
    	}
    }
    
}