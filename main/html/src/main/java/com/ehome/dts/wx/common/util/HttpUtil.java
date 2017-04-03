package com.ehome.dts.wx.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ehome.dts.wx.common.exception.LogicException;
import com.ehome.dts.wx.oldcontroller.result.GMResult;
import com.ehome.util.util.net.HttpClientUtil;

@Component
public class HttpUtil {
	private static final Logger logger = Logger.getLogger(HttpUtil.class);

	@Value("${internal.system.sercret}")
	public String internalSystemSercret;

	public final String from = "internal_server";

	/**
	 * @Title  postService 
	 * @date 2016年12月22日 下午4:00:20 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  发起post请求
	 * @param header
	 * @param url
	 * @param nvpsMap
	 * @param clazz
	 * @return
	 * @throws LogicException
	 */
	public <T> T postService(Map<String, String> header, String url, Map<String, String> nvpsMap, Class<T> clazz)
			throws LogicException {
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (String key : nvpsMap.keySet()) {
				nvps.add(new BasicNameValuePair(key, nvpsMap.get(key)));
			}
			if (header == null) {
				header = new HashMap<String, String>();
			}
			header.put("From", "internal_server");
			header.put("Token", internalSystemSercret);
			String resultString = HttpClientUtil.postWithHeader(header, url, nvps);
			logger.info(resultString);
			GMResult result = JSON.parseObject(resultString, GMResult.class);
			if (result.getAct() != 0) {
				throw new LogicException("网络服务调用错误");
			}
			return JSON.parseObject(result.getResult() + "", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("访问网络错误");
		}
	}

	/**
	 * 
	 * @Title  postService 
	 * @date 2016年12月22日 下午4:01:06 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  post请求
	 * @param header
	 * @param url
	 * @param nvpsMap
	 * @return
	 * @throws LogicException
	 */
	public int postService(Map<String, String> header, String url, Map<String, String> nvpsMap) throws LogicException {
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (String key : nvpsMap.keySet()) {
				nvps.add(new BasicNameValuePair(key, nvpsMap.get(key)));
			}
			if (header == null) {
				header = new HashMap<String, String>();
			}
			header.put("From", "internal_server");
			header.put("Token", internalSystemSercret);
			String resultString = HttpClientUtil.postWithHeader(header, url, nvps);
			GMResult result = JSON.parseObject(resultString, GMResult.class);
			if (result.getAct() != 0) {
				throw new LogicException("网络服务调用错误");
			}
			return result.getAct();
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("访问网络错误");
		}
	}

	/**
	 * @Title  postServiceArray 
	 * @date 2016年12月22日 下午4:01:46 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  post 返回数组
	 * @param header
	 * @param url
	 * @param nvpsMap
	 * @param clazz
	 * @return
	 * @throws LogicException
	 */
	public <T> List<T> postServiceArray(Map<String, String> header, String url, Map<String, String> nvpsMap,
			Class<T> clazz) throws LogicException {
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (String key : nvpsMap.keySet()) {
				nvps.add(new BasicNameValuePair(key, nvpsMap.get(key)));
			}
			if (header == null) {
				header = new HashMap<String, String>();
			}
			header.put("From", "internal_server");
			header.put("Token", internalSystemSercret);
			String resultString = HttpClientUtil.postWithHeader(header, url, nvps);
			GMResult result = JSON.parseObject(resultString, GMResult.class);
			if (result.getAct() != 0) {
				throw new LogicException("网络服务调用错误" + resultString);
			}
			logger.info(result.getResult() + "");
			return JSON.parseArray(result.getResult() + "", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("访问网络错误");
		}
	}

	/**
	 * @Title getService
	 * @date 2016年12月22日 下午3:35:20
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description 发起get请求
	 * @param header
	 * @param url
	 * @param nvpsMap
	 * @param clazz
	 * @return
	 * @throws LogicException
	 */
	public <T> T getService(Map<String, String> header, String url, Map<String, String> nvpsMap, Class<T> clazz)
			throws LogicException {
		try {
			if (nvpsMap != null && nvpsMap.size() > 0) {
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				for (String key : nvpsMap.keySet()) {
					nvps.add(new BasicNameValuePair(key, nvpsMap.get(key)));
				}
				url = HttpClientUtil.buildGetUrl(url, nvps);
			}

			if (header == null) {
				header = new HashMap<String, String>();
			}
			header.put("From", "internal_server");
			header.put("Token", internalSystemSercret);
			String resultString = HttpClientUtil.getWithHeader(header, url);
			logger.info(resultString);
			GMResult result = JSON.parseObject(resultString, GMResult.class);
			if (result.getAct() != 0) {
				throw new LogicException("网络服务调用错误");
			}
			return JSON.parseObject(result.getResult() + "", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("访问网络错误");
		}
	}
	
	/**
	 * @Title  getServiceArray 
	 * @date 2016年12月22日 下午4:01:46 
	 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>
	 * @Description  get 返回数组
	 * @param header
	 * @param url
	 * @param nvpsMap
	 * @param clazz
	 * @return
	 * @throws LogicException
	 */
	public <T> List<T> getServiceArray(Map<String, String> header, String url, Map<String, String> nvpsMap,
			Class<T> clazz) throws LogicException {
		try {
			if (nvpsMap != null && nvpsMap.size() > 0) {
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				for (String key : nvpsMap.keySet()) {
					nvps.add(new BasicNameValuePair(key, nvpsMap.get(key)));
				}
				url = HttpClientUtil.buildGetUrl(url, nvps);
			}
			
			if (header == null) {
				header = new HashMap<String, String>();
			}
			header.put("From", "internal_server");
			header.put("Token", internalSystemSercret);
			String resultString = HttpClientUtil.getWithHeader(header, url);
			GMResult result = JSON.parseObject(resultString, GMResult.class);
			if (result.getAct() != 0) {
				throw new LogicException("网络服务调用错误" + resultString);
			}
			return JSON.parseArray(result.getResult() + "", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LogicException("访问网络错误");
		}
	}
}
