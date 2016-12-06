package com.zeyu.CMS.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zeyu.controller.BaseAction;
import com.zeyu.entity.User;
import com.zeyu.service.UserService;

/**
 * 用户管理
 * 
 * @author lisheng
 *
 */
@Controller
@RequestMapping("/CMS")
public class CMSUserAction extends BaseAction {

	@Autowired
	UserService userService;

	// 普通用户 user_kind=1
	// 展示普通用户列表
	@RequestMapping(value = "/adminShowList.action", method = RequestMethod.GET)
	public void adminShowList(String json, HttpServletResponse response) {
		String result = JSON.toJSONString(userService.findByKind(0));
		out(response, result);
	}

	// 管理员修改角色
	@RequestMapping(value = "/adminUpdateRole.action", method = RequestMethod.POST)
	public void adminUpdateRole(HttpServletResponse response, HttpSession session, String user_name, String user_pass, String user_email,
			String user_tele, String user_kind) {

		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setUser_email(user_email);
			user.setUser_kind(Integer.parseInt(user_kind));
			user.setUser_name(user_name);
			user.setUser_pass(user_pass);
			String result= userService.update(user)+"";
			out(response, result);
		}
	}

	// 管理员删除角色
	@RequestMapping(value = "/adminDeleteRole.action", method = RequestMethod.POST)
	public void adminDeleteRole(HttpServletResponse response, String id) {
		String result = userService.delete(id) + "";
		out(response, result);
	}
	// 管理员批量删除角色
		@RequestMapping(value = "/adminBatchDeleteRole.action", method = RequestMethod.POST)
		public void adminBatchDeleteRole(HttpServletResponse response, String id) {
			String result = userService.delete(id) + "";
			out(response, result);
		}

	// 管理员添加角色
	@RequestMapping(value = "/adminAddRole.action", method = RequestMethod.POST)
	public void adminAddRole(Model model, HttpServletResponse response, String user_name, String user_pass,String user_tele, String user_email
			, String user_kind) {
		User user = new User();
		user.setUser_email(user_email);
		user.setUser_kind(Integer.parseInt(user_kind));
		user.setUser_name(user_name);
		user.setUser_pass(user_pass);
		userService.add(user);
	}
}
