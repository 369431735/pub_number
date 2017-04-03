package com.ehome.dts.wx.common.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ehome.util.util.net.NetUtil;

@Controller
public class LogFilter extends OncePerRequestFilter{
	private static final Logger LOGGER = Logger.getLogger(LogFilter.class);
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String ip = NetUtil.getRemoteHost(request);
		Enumeration<String> enumeration = request.getParameterNames();
		LOGGER.info(ip + request.getMethod() +"========="+request.getServletPath()+" params:");
		while (enumeration.hasMoreElements()) {
			String paraName = enumeration.nextElement();
			String content = "picString";
			if(!"picString".equals(paraName)){
				content = request.getParameter(paraName);
			}
			LOGGER.info(paraName+"====="+content);
		}
		chain.doFilter(request, response);
	}

}
