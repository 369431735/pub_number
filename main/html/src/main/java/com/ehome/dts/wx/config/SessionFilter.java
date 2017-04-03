package com.ehome.dts.wx.config;//package com.ehome.dts.wx.config;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.ehome.dts.wx.common.bean.Strings;
//import com.ouyang.util.string.StringUtil;
//@Controller
//public class SessionFilter extends OncePerRequestFilter  {
//	@Override
//	protected void doFilterInternal(HttpServletRequest request,
//			HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		String url = request.getRequestURI();
//		System.out.println("filter url is :"+url);
//		String httpOpenId = request.getSession().getAttribute(Strings.OPEN_ID)+"";
//		if(isAccess(url)){
//			doFilter(request, response, filterChain);
//			return;
//		}
////		if(StringUtil.isBlank(httpOpenId)){
////			response.sendRedirect("/web"+url);
////			return;
////		}
//		doFilter(request, response, filterChain);
//	}
//	
//	
//	private static boolean isAccess(String url){
//		List<String> accessUrls = new ArrayList<String>();
//		accessUrls.add("/dist/");
//		accessUrls.add("/web/");
//		accessUrls.add("/user/");
//		accessUrls.add("/html/");
//		accessUrls.add("/image/");
//		accessUrls.add("/orders/backlog");
//		for (String accessUrl : accessUrls) {
//			if(url.contains(accessUrl)){
//				return true;
//			}
//		}
//		return false;
//	}
//}