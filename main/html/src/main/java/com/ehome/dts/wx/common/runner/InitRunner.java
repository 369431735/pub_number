package com.ehome.dts.wx.common.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * 初始化数据配置
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
@Component
public class InitRunner implements CommandLineRunner {
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("====================Runner is running ");
		
	}

}
