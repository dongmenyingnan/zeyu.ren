package com.zeyu.intercapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		arg1.setCharacterEncoding("utf-8");
		arg0.setCharacterEncoding("utf-8");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		arg1.setCharacterEncoding("utf-8");
		arg0.setCharacterEncoding("utf-8");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		arg1.setCharacterEncoding("utf-8");
		arg0.setCharacterEncoding("utf-8");
		return true;
	}

}
