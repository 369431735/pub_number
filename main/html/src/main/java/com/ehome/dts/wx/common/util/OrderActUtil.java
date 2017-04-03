package com.ehome.dts.wx.common.util;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.owtelse.codec.Base64;

/**
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class OrderActUtil {
	
	public static String getChangeObjectString(Object object) throws UnsupportedEncodingException {
		if(null == object){
			return null;
		}
		String jsonString = JSON.toJSONString(object);
		return Base64.encode(jsonString.getBytes());
	}
	
	public static String getChangeJsonString(String objectString) throws UnsupportedEncodingException {
		return Base64.decode(objectString.getBytes());
	}
	
}
