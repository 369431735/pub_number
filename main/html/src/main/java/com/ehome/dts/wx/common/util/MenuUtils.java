package com.ehome.dts.wx.common.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.bean.Button;
import com.ehome.dts.wx.common.bean.Menu;

@Component
public class MenuUtils {
	@Autowired
	private AccessTokenUtils accessTokenUtils;
	@Value("${weixinServerName}")
	private String weixinServerName;
//	public static void main(String[] args) {
//		new MenuUtils().createCommMenu();
//	}
	public void createCommMenu() {
		String ACCESS_TOKEN = accessTokenUtils.getSavedAccess_token();// 获取AccessToken，AccessTokenUtils是封装好的类
		// 拼接api要求的httpsurl链接
		String urlString = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ ACCESS_TOKEN;
		try {
			// 创建一个url
			URL reqURL = new URL(urlString);
			// 拿取链接
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL
					.openConnection();
			httpsConn.setDoOutput(true);
			// 取得该连接的输出流，以读取响应内容
			OutputStreamWriter osr = new OutputStreamWriter(
					httpsConn.getOutputStream());
			osr.write(getMenuJson());// 使用本类外部方法getMenuJson()
			osr.close();

			// 返回结果
			InputStreamReader isr = new InputStreamReader(
					httpsConn.getInputStream());
			// 读取服务器的响应内容并显示
			char[] chars = new char[1024];
			String reslut = "";
			int len;
			while ((len = isr.read(chars)) != -1) {
				reslut += new String(chars, 0, len);
			}
			System.out.println("返回结果:" + reslut);
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO i18n
	 * <a href="xi.yang@i-jia.net">yangxi</a>
	 * @return
	 */
	private String getMenuJson() {
		Menu menu = new Menu();
		List<Button> button = new ArrayList<Button>();
		
		Button news = new Button();
		news.setName("有新奇");
		news.setType("view");
		news.setUrl("http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MzI5OTE1OTk0NA==#wechat_webview_type=1&wechat_redirect");
		button.add(news);
		
		Button orders = new Button();
		orders.setName("看订单");
		orders.setType("view");
		orders.setUrl(weixinServerName+"/web/orderList");
		button.add(orders);
		
		Button service = new Button();
		service.setName("享服务");
		List<Button> sub_button = new ArrayList<Button>();
		
		Button sys = new Button();
		sys.setType("scancode_push");
		sys.setKey("button_3_1");
		sys.setName("扫一扫");
		sub_button.add(sys);
		
		Button userComButton = new Button();
		userComButton.setName("关注商品");
		userComButton.setType("view");
		userComButton.setUrl(weixinServerName+"/web/userCommodities");
		sub_button.add(userComButton);
		
		Button userButton = new Button();
		userButton.setName("个人中心");
		userButton.setType("view");
		userButton.setUrl(weixinServerName+"/web/personalCenter");
		sub_button.add(userButton);
		
		service.setSub_button(sub_button);
		button.add(service);
		
		menu.setButton(button);
		return JSON.toJSONString(menu);
	}
}
