package com.ehome.dts.wx.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
	public static final String ERROR_PATH = "/error";
	@RequestMapping(value=ERROR_PATH)
	public String handleError(){
		return "html/404error.html";
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
