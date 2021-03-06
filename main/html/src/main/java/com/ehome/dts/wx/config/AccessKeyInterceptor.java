package com.ehome.dts.wx.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class AccessKeyInterceptor extends WebMvcConfigurerAdapter  {
	public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(new HandlerInterceptorAdapter() {

	          @Override
	          public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	                                   Object handler) throws Exception {
	        	response.setHeader("Access-Control-Allow-Origin", "*");
	      		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	      		response.setHeader("Access-Control-Allow-Methods", "GET");
	      		response.setHeader("Allow", "GET");
	      		return true;
	          }
	      }).addPathPatterns("/*");
	  }
	
}