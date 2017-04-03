package com.ehome.dts.wx.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ehome.dts.wx.common.util.EncoderHandler;
import com.ehome.dts.wx.common.util.wx.AesException;
import com.ehome.dts.wx.common.util.wx.WXBizMsgCrypt;
import com.ehome.dts.wx.common.util.wx.XMLParse;
import com.ehome.dts.wx.dao.UserBindDao;
import com.ehome.dts.wx.entity.UserBind;

@Service
public class TokenService {
	private static final Logger logger = Logger.getLogger(TokenService.class);
	@Value("${weixinToken}")
	private String weixinToken;
	@Value("${weixinServerName}")
	private String weixinServerName;
	@Value("${weixinAppId}")
	private String weixinAppId;
	@Value("${weixinEncodingAESKey}")
	private String weixinEncodingAESKey;
	@Autowired
	private UserBindDao userBindDao;
	@Resource
	private UserBindService userBindService;
    /**
     * 微信开发者验证
     * @param wxAccount
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @Transactional
    public boolean validate(String signature,String timestamp,String nonce){
        if(signature!=null&&timestamp!=null&nonce!=null) {
            String[] str = {weixinToken, timestamp+"", nonce+""};
            logger.info(weixinToken);
            Arrays.sort(str); // 字典序排序
            String bigStr = str[0] + str[1] + str[2];
            // SHA1加密    
            String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
            logger.info(digest+"======"+signature);
            // 确认请求来至微信
            if (digest.equals(signature)) {
                //最好此处将echostr存起来，以后每次校验消息来源都需要用到
                return true;
            }
        }
        return false;
    }
    
    @Transactional
    public String getMessage(String signature, String timestamp, String nonce, String msgXml){
    	try {
			WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(weixinToken, weixinEncodingAESKey, weixinAppId);
//			String msg = wxBizMsgCrypt.decryptMsg(signature, timestamp, nonce, msgXml);
			
			Object[] encrypt = XMLParse.extract(msgXml);
			String result = wxBizMsgCrypt.decrypt(encrypt[1].toString());
			logger.info("result is ====="+result);
			for (Object object : encrypt) {
				System.out.println("object " + object.toString());
			}
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(result);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			Element root = document.getDocumentElement();
			
			String toUserName = getElementByName("ToUserName", root);
			String fromUserName = getElementByName("FromUserName", root);
			String createTime = getElementByName("CreateTime", root);
			String msgType = getElementByName("MsgType", root);
			String event = getElementByName("Event",root);
			
			logger.info("toUserName============"+toUserName);
			logger.info("fromUserName============"+fromUserName);
			logger.info("createTime============"+createTime);
			logger.info("msgType============"+msgType);
			logger.info("event============"+event);
			UserBind userBind = userBindDao.findTopByOpenid(fromUserName);
			long curTime = System.currentTimeMillis();
			// 事件消息
			if("event".equals(msgType)){
				// 关注自动回复
				if("subscribe".equals(event)){
					//关注
					if(userBind != null){
						userBind.setUpdateTime(curTime);
						userBind.setDeleted(false);
					}else {
						userBind = new UserBind();
						userBind.setCreateTime(curTime);
						userBind.setUpdateTime(curTime);
						userBind.setOpenid(fromUserName);
						userBindDao.save(userBind);
					}
				}
				// 取消关注自动回复
				if("unsubscribe".equals(event)){
					//取消关注
					if(userBind != null){
						userBind.setUpdateTime(curTime);
						userBind.setDeleted(true);
					}
				}
				
			}
			
			return "";
		} catch (AesException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "";
    }

	private String getElementByName(String name, Element root) {
		String result = "";
		NodeList nodeList = root.getElementsByTagName(name);
		if(nodeList != null){
			Node node = nodeList.item(0);
			if(node != null){
				result = node.getTextContent();
			}
		}
		return result;
	}
	
	/**
	 * @Title  getRedirectUrl 
	 * @date 2017年1月9日 下午9:37:38 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  获取跳转URL地址
	 * @param state
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getRedirectUrl(String state) throws UnsupportedEncodingException {
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
}