package com.zhiyou.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		Object admin = session.getAttribute("admin");
		
		if (user!=null || admin!=null) {
			return true;
		}else{
			response.sendRedirect("http://localhost:8080/video/nologin");
			return false;
		}
	}

}
