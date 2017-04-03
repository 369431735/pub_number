package com.ehome.dts.wx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ehome.dts.wx.oldcontroller.result.GMResult;

@Controller
public class BaseController{
	@Autowired
	public GMResult gmResult;
}
