package com.zeyu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zeyu.entity.Answer;
import com.zeyu.entity.User;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.AnswerVo;
import com.zeyu.service.AnswerService;
import com.zeyu.service.QuestionService;

@Controller
public class AnswerAction extends BaseAction{
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;

	@RequestMapping(value = "/answers.action")
	public String answers(Model model, Integer question_id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(question_id==null){
			question_id=questionService.getQuestionCount()+1;
		}
	
		if(questionService.hitsCheck(question_id,user.getUser_id())){
			
			hitsCollect hit = new hitsCollect();
			hit.setColl_ques_id(question_id);
			hit.setColl_user_id(user.getUser_id());
			questionService.askhits(hit);
			questionService.hits(question_id);
		}
		
		
		AnswerVo answerVo = new AnswerVo();
		answerVo = answerService.getAnswerVo(question_id);
		answerVo.setQuestion_time(questionService.question_time(question_id));
		model.addAttribute("answerVo", answerVo);
		return "answers";
	}

	@RequestMapping(value = "/reply.action")
	public String reply(Model model, Integer question_id, String answer_content,HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
			Date create_time = new Date();
			Answer answer = new Answer();
			answer.setQuestion_id(question_id);
			answer.setUser_id(user.getUser_id());
			answer.setAnswer_content(answer_content);
			answer.setCreate_time(create_time);
			answerService.reply(answer);
			return "redirect:/answers.action?question_id=" + question_id;
		}
	}
	@RequestMapping(value="/addVotes.action")
	public void  addVotes(String json, HttpServletResponse response,String answer_id){
		Answer oldAnswer=answerService.getAnswerByID(Integer.parseInt(answer_id));
		oldAnswer.setAnswer_votes(oldAnswer.getAnswer_votes()+1);
		String result = JSON.toJSONString("success");
		out(response, result);
	}

}
