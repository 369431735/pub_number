/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.ehome.dts.wx.common.util.wx;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * XMLParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
public class XMLParse {
//	public static void main(String[] args) throws AesException {
//		String token = "b610ce7792c2409a88a6a865329785d5";
//		String encodingAesKey = "xh5yoeEnt2NEp8IREUrxjtVxUcy1me3ifh4Ep7CMC5n";
//		String appId = "wxad43a6946b75249a";
//		String incode = "<xml><ToUserName><![CDATA[gh_22fa96886f2e]]></ToUserName>"
//				+ "<Encrypt><![CDATA[ul6L+9wpBxQ7Dy4/GtPGjDnwR2isHmoAuR5BanHdnYQDd8KEcYN8outEmsizFpNk1Gk04ZB4fXhd9QOa9sTwlDzapm78R7GJ4r6Hy70NMmrUbm7iXgKLOQqJHsPNeG17W+wKgfSp7wsgWN2bYupsH018AZrB8oKnM8Jhd8gYWqTWo42wvxPF6jzk1OWf6v7vPXOfmLv5gwcwMwpE1PpLgOiyFlgcbxXzedoTdduy/0ZRw3pPcRXP04PxbumEjfTdAwSJWdFTRdiWvQVJBGUnGDzmpi1HBKsISPOOW9Qp1aUK/Q5wPg+SEV0wjR7Qorr2i4AsucRgpV5pbxdXELERaFqfhWD/GOw+/MN+/pWuotxDNR+YT4KCzRfz3TOtSvH+2Hrp+6z"
//				+ "RwsjiOyW4rjoCn+YLqANGjUWubWuZMyFUmv2Jgj/EEif3NPqSokNvuiTiSxjOyKIDuXD+3r9OQO7fHA==]]></Encrypt></xml>";
//		Object[] resut = extract(incode);
//		String userOpenId = resut[2].toString();
//		String encrypt = resut[1].toString();
//		System.out.println(userOpenId);
//		System.out.println(encrypt);
//		
//		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
//	}

	/**
	 * 提取出xml数据包中的加密消息
	 * @param xmltext 待提取的xml字符串
	 * @return 提取出的加密消息字符串
	 * @throws AesException 
	 */
	public static Object[] extract(String xmltext) throws AesException     {
		Object[] result = new Object[3];
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmltext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("ToUserName");
			result[0] = 0;
			result[1] = nodelist1.item(0).getTextContent();
			result[2] = nodelist2.item(0).getTextContent();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseXmlError);
		}
	}

	/**
	 * 生成xml消息
	 * @param encrypt 加密后的消息密文
	 * @param signature 安全签名
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @return 生成的xml字符串
	 */
	public static String generate(String encrypt, String signature, String timestamp, String nonce) {

		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
				+ "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
				+ "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
		return String.format(format, encrypt, signature, timestamp, nonce);

	}
}
