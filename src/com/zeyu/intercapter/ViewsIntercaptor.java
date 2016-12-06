package com.zeyu.intercapter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zeyu.permission.Permission;

/**
 * FreeMarker视图拦截器，页面展示之前做一些通用处理
 * 
 * @version V1.0.0
 * @date Dec 12, 2013 4:20:04 PM
 */
public class ViewsIntercaptor extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 处理Permission Annotation，实现方法级权限控制
		HandlerMethod method = (HandlerMethod) handler;
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "application/json");
		Permission permission = method.getMethodAnnotation(Permission.class);
		//User user = (User) request.getSession().getAttribute("user");
		Integer rid = 0;
		// 如果为空在表示该方法不需要进行权限验证
		if (permission == null) {
			return true;
		}
//		if (user == null) {
//
//			PrintWriter out = response.getWriter();
//			out.print("{\"result\":\"对不起，您没有权限进行该操作\"}");
//			out.flush();
//			out.close();
//			return false;
//		}
//		rid = user.getRoleid();
//		// 验证是否具有权限
//		System.out.println(rid);
//		String[] s = permission.value();
//		for (int j = 0; j < s.length; j++) {
//			if (rid == Integer.parseInt(s[j])) {
//				return true;
//			}
//		}
		PrintWriter out = response.getWriter();
		out.print("{\"result\":\"对不起，您没有权限进行该操作\"}");
		out.flush();
		out.close();
		return false;

	}
}