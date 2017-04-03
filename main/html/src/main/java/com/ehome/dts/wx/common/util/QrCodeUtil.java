package com.ehome.dts.wx.common.util;

import org.apache.commons.lang3.math.NumberUtils;

import com.ehome.util.util.string.StringUtil;

/**
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class QrCodeUtil {
	public static final String SEPARATOR = String.valueOf((char) 29);
	
	public static int getCommodityId(String qrCode){
		if(StringUtil.isBlank(qrCode)){
			return 0;
		}
		return NumberUtils.toInt(qrCode.split(SEPARATOR)[1]);
	}

	public static int getType(String qrCode) {
		if(StringUtil.isBlank(qrCode)){
			return 0;
		}
		return NumberUtils.toInt(qrCode.split(SEPARATOR)[0]);
	}
	
}