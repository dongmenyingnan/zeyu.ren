package com.zeyu.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeyu.entity.Question;
import com.zeyu.entity.User;
import com.zeyu.service.QuestionService;

@Controller
public class QuestionAction {

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/ask.action", method = RequestMethod.POST)
	public String ask(Model model, String comment,String label, String commentAddition, Integer anonymous, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		Integer user_id = user.getUser_id();
		Question question = new Question();
		Date create_time = new Date();
		question.setQuestion_comment(comment);
		question.setComment_addition(commentAddition);
		question.setQuestion_label(label);
		if (anonymous != null) {
			question.setAnonymous(anonymous);
		} else {
			question.setAnonymous(0);
		}
		question.setUser_id(user_id);
		question.setHits(0);
		question.setAttentions(0);
		question.setCreate_time(create_time);
		questionService.ask(question);
		return "redirect:/home.action";
	}
}
