package com.ehome.dts.wx.common.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.template.Data;
import com.ehome.dts.wx.common.bean.template.ModeMessage;
import com.ehome.dts.wx.common.bean.template.PerData;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.util.util.net.HttpClientUtil;
import com.ehome.util.util.string.StringUtil;

/**
 * 
 * 模版消息
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
@Component
public class TemplateUtil {
	@Value("${wechart.message.order}")
	private String msgOrder;
	@Autowired
	private AccessTokenUtils accessTokenUtils;
	private static final Logger logger = Logger.getLogger(TemplateUtil.class);
	private final String COLOR = "#3B9AC6";//字体颜色
	private final String CONTENT = "请仔细核对订单信息，如有疑问，请与商家联系。";//提醒
	private String orderNumber;
	private double amount;
	private List<String> itemNames;
	private String shopName;
	private String title;
	private String url;
	private String touser;
	
//	public static void main(String[] args) throws LogicException {
//		TemplateUtil templateUtil = new TemplateUtil();
//		templateUtil.setTitle("订单状态改变");
//		templateUtil.setOrderNumber("201523565445");
//		templateUtil.setAmount(2000f);
//		templateUtil.setUrl("http://www.baidu.com");
//		templateUtil.setTouser("oiC-lxHQtI--qNlsLz94EV0062cA");
//		templateUtil.setShopName("红星美凯龙");
//		List<String> itemNames = new ArrayList<String>();
//		itemNames.add("桌子");
//		itemNames.add("椅子");
//		itemNames.add("电脑桌");
//		itemNames.add("床");
//		itemNames.add("床垫");
//		templateUtil.setItemNames(itemNames);
//		templateUtil.pushWechartMsg();
//	}
	
	public void pushWechartMsg() throws LogicException{
		try {
//			if(this.itemNames == null || this.itemNames.size() == 0){
//				throw new LogicException("商品为空了！不能发送该微信模版消息。");
//			}
			ModeMessage modeMessage = new ModeMessage();
			logger.info("message temple = "+msgOrder);
			modeMessage.setTemplate_id(msgOrder);
			modeMessage.setUrl(url);
			modeMessage.setTopcolor(COLOR);
			modeMessage.setTouser(touser);
			
			Data data = new Data();
			PerData first = new PerData();
			first.setValue(title + "\n");
			data.setFirst(first);
			
			PerData keyword1 = new PerData();
			keyword1.setValue(orderNumber);
			keyword1.setColor(COLOR);
			data.setKeyword1(keyword1);
			
			PerData keyword2 = new PerData();
			StringBuffer sb = new StringBuffer();
			for (String item : itemNames) {
				if(StringUtil.isNotBlank(item)){
					sb.append(item).append(" ");
				}
			}
			keyword2.setValue(sb.toString());
			keyword2.setColor(COLOR);
			data.setKeyword2(keyword2);
			
			PerData keyword3 = new PerData();
			keyword3.setValue(amount+"元");
			keyword3.setColor(COLOR);
			data.setKeyword3(keyword3);
			
			PerData keyword4 = new PerData();
			keyword4.setValue(shopName+"\n");
			keyword4.setColor(COLOR);
			data.setKeyword4(keyword4);
			
			PerData keyword5 = new PerData();
			keyword5.setValue(CONTENT);
			data.setKeyword5(keyword5);
			
			modeMessage.setData(data);
			String json = JSON.toJSONString(modeMessage);
			String urls = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessTokenUtils.getSavedAccess_token();
			String result = HttpClientUtil.post(urls, json);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("发送微信模版消息错误!");
		}
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public List<String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
}
