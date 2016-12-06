package com.zeyu.CMS.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zeyu.controller.BaseAction;
import com.zeyu.service.AnswerService;
import com.zeyu.service.QuestionService;

/**
 * 评论管理
 * @author lisheng
 *
 */
@Controller
@RequestMapping("/CMS/question")
public class CMSQuestionAction extends BaseAction{
	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/questionList.action", method = RequestMethod.GET)
	public void questionList(String json, HttpServletResponse response) {
		String result = JSON.toJSONString(questionService.getAllQuestion());
		out(response, result);
	}
	@RequestMapping(value = "/answersOfQuestion.action", method = RequestMethod.GET)
	public void answersOfQuestion(String json, HttpServletResponse response,String questionId) {
		String result = JSON.toJSONString(answerService.getAnswerVo(Integer.parseInt(questionId)));
		out(response, result);
	}
}
