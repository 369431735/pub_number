package com.ehome.dts.wx.common.bean;

import com.ehome.dts.wx.common.bean.result.Shop;

/**
 * @ClassName: Shop  
 * @Description: 显示店铺详情使用
 * @author <a href=mailto:xianzhi.gan@i-jia.net>JimmyGan</a>  
 * @date 2016年12月22日 下午6:08:18
 */
public class WatchShop extends Shop {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -2932366865626208020L;
	private boolean isWatched;

	public boolean isWatched() {
		return isWatched;
	}

	public void setWatched(boolean isWatched) {
		this.isWatched = isWatched;
	}
	
}
