package com.block.comm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getSession().getAttribute("id") == null) {
				response.sendRedirect("/comm/login.chain");
				return false;
			}else {
				return true;
			}
		} else {
			return true;
		}
	}
}
