package com.zeyu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.chenlb.mmseg4j.example.Complex;
import com.zeyu.entity.Answer;
import com.zeyu.entity.Page;
import com.zeyu.entity.Question;
import com.zeyu.entity.RequestFlag;
import com.zeyu.entity.User;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.AnswerService;
import com.zeyu.service.QuestionService;

@Controller
public class HomeAction extends BaseAction {
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;

	// 首页问题搜索
	@RequestMapping(value = "search.action", method = RequestMethod.GET)
	public String search(HttpSession session, Model model, Integer page, String searchContent, Integer flag)
			throws UnsupportedEncodingException {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		RequestFlag requestFlag = new RequestFlag();
		String gb = new String(searchContent.getBytes("ISO-8859-1"), "UTF-8");
		model.addAttribute("searchContent", gb);
		if (flag == null || flag == 1) {
			requestFlag.setMostNew("");
			requestFlag.setMostHot("class=\"active\"");
			requestFlag.setActiveHot("active");
			requestFlag.setActiveNew("");
			requestFlag.setActiveMyAnswer("");
			requestFlag.setActiveMyQuestion("");
		}
		model.addAttribute("requestFlag", requestFlag);

		Complex c = new Complex();
		
		String s = gb;
		try {
			s = c.segWords(gb, " ");
			System.out.println(c.segWords(gb, " | "));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			List<Page> pages = new ArrayList<>();
			int size = questionService.getFilterQuestionCount(s);
			System.out.println(size);
			int maxPage = (int) Math.ceil(1.0 * size / 10);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage) {
				page = maxPage;
			}
			pages = getPages(page, maxPage, 1);
			// 最热问题列表
			List<QuestionVo> questionVo = new ArrayList<QuestionVo>();
			//s即为字符串去掉空格之后的文字。searchContent为输入的全部信息
			questionVo = questionService.getFilterQuestionByPage(1, page, s);
		
			model.addAttribute("questions", questionVo);

			model.addAttribute("Pages", pages);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
		}

		// 分页核心代码
		/*
		 * 1,2,3光标指向1,2,3 1,2,3...maxPage-1,maxPage 4,5,6...maxPage-4
		 * ...x,x+1...maxPage-1,maxPage maxPage-2,maxPage-3
		 * 1,2...maxPage-2,maxPage-1.. maxPage-1,maxPage
		 * 1,2,3...maxPage-1,maxPage
		 */

	}

	// 首页默认显示的方法 数据默认显示到最新列表
	@RequestMapping(value = "/home.action")
	public String homeNewQuestions(HttpSession session, Model model, Integer page, Integer flag) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		RequestFlag requestFlag = new RequestFlag();
		model.addAttribute("searchContent", null);
		System.out.println(page+"     "+flag);
		if (flag == null || flag == 1) {
			requestFlag.setMostNew("");
			requestFlag.setMostHot("class=\"active\"");
			requestFlag.setActiveHot("active");
			requestFlag.setActiveNew("");
			requestFlag.setActiveMyAnswer("");
			requestFlag.setActiveMyQuestion("");
		}
		model.addAttribute("requestFlag", requestFlag);
		try {
			List<Page> pages = new ArrayList<>();
			int size = questionService.getQuestionCount();

			int maxPage = (int) Math.ceil(1.0 * size / 10);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage) {
				page = maxPage;
			}
			pages = getPages(page, maxPage, 1);
			// 最热问题列表
			List<QuestionVo> questionVo = new ArrayList<QuestionVo>();
			
			questionVo = questionService.getQuestionByPage(2, page); 
			
			
			model.addAttribute("questions", questionVo);

			model.addAttribute("Pages", pages);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";}
	}

	// 首页最热 问题列表 显示
	@RequestMapping(value = "/homeHotQuestions.action")
	public String homeHotQuestions(HttpSession session, Model model, Integer page, Integer flag) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		RequestFlag requestFlag = new RequestFlag();
		if (page == null)
			page = 1;
		if (flag == null || flag == 2) {
			requestFlag.setMostNew("class=\"active\"");
			requestFlag.setMostHot("");
			requestFlag.setActiveHot("");
			requestFlag.setActiveNew("active");
		}
		model.addAttribute("requestFlag", requestFlag);
		try {
			List<Page> pagesNew = new ArrayList<>();
			int size = questionService.getQuestionCount();

			int maxPage = (int) Math.ceil(1.0 * size / 10);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage) {
				page = maxPage;
			}

			pagesNew = getPages(page, maxPage, 2);

			// 最新问题列表
			List<QuestionVo> questionVoNew = new ArrayList<QuestionVo>();
			questionVoNew = questionService.getQuestionByPage(1, page);
			model.addAttribute("questionsNew", questionVoNew);
			model.addAttribute("PagesNew", pagesNew);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
		}
	}

	// 首页我的 提问 问题列表 显示（用户登录后显示）
	@RequestMapping(value = "/homeMyQuestions.action")
	public String homeMyQuestions(HttpSession session, Model model, Integer page) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		
		RequestFlag requestFlag = new RequestFlag();
		model.addAttribute("searchContent", null);


		requestFlag.setMostNew("");
		requestFlag.setMostHot("");
		requestFlag.setMyQuestion("class=\"active\"");
		requestFlag.setActiveHot("");
		requestFlag.setActiveNew("");
		requestFlag.setActiveMyAnswer("");
		requestFlag.setActiveMyQuestion("active");

		model.addAttribute("requestFlag", requestFlag);

		try {
			List<Page> pagesMyQuestion = new ArrayList<>();

			// 最热问题列表
			if (user != null) {
				int size = questionService.getQuestionCountByUserId(user.getUser_id());

				int maxPage = (int) Math.ceil(1.0 * size / 10);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage) {
					page = maxPage;
				}
				pagesMyQuestion = getPages(page, maxPage, 1);

				List<Question> myQuestions = new ArrayList<Question>();
				myQuestions = questionService.getPageQuestionsByUserId(user.getUser_id(), page);
				List<QuestionVo> myQuestionVos = new ArrayList<>();
				for (int i = 0; i < myQuestions.size(); i++) {
					myQuestionVos.add(questionService.getQuestionVoByQuestionId(myQuestions.get(i).getQuestion_id()));
				}

				model.addAttribute("MyQuestions", myQuestionVos);
			}

			model.addAttribute("PagesMyQuestion", pagesMyQuestion);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
		}
	}

	// 首页我的 回答 问题列表 显示（用户登录后显示）
	@RequestMapping(value = "/homeMyAnsQuestions.action")
	public String homeMyAnsQuestions(HttpSession session, Model model, Integer page) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		if (page == null)
			page = 1;
		RequestFlag requestFlag = new RequestFlag();
		model.addAttribute("searchContent", null);


		requestFlag.setMostNew("");
		requestFlag.setMostHot("");
		requestFlag.setMyQuestion("");
		requestFlag.setMyAnswer("class=\"active\"");
		requestFlag.setActiveHot("");
		requestFlag.setActiveNew("");
		requestFlag.setActiveMyAnswer("active");
		requestFlag.setActiveMyQuestion("");
		model.addAttribute("requestFlag", requestFlag);

		if (user != null) {
			List<Answer> myAnswers = new ArrayList<Answer>();
			myAnswers = answerService.getPageAnswersByUserId(user.getUser_id(), page);

			List<QuestionVo> myAnswersQuestion = new ArrayList<>();
			for (int i = 0; i < myAnswers.size(); i++) {
				myAnswersQuestion.add(questionService.getQuestionVoByQuestionId(myAnswers.get(i).getQuestion_id()));
			}
			model.addAttribute("MyAnsQuestions", myAnswersQuestion);

			List<Page> pagesMyAnsQuestion = new ArrayList<>();
			int size = answerService.getAnswerCountByUserId(user.getUser_id());

			int maxPage = (int) Math.ceil(1.0 * size / 10);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage) {
				page = maxPage;
			}

			pagesMyAnsQuestion = getPages(page, maxPage, 2);
			model.addAttribute("PagesMyAnsQuestion", pagesMyAnsQuestion);
		}

		return "index";
		}
	}

	public List<Page> getPages(int page, int maxPage, int flag) {
		List<Page> pages = new ArrayList<>();
		Page f = new Page();
		f.setContent("上一页");
		f.setPageNum(page - 1);
		f.setStyle("");
		f.setFlag(flag);
		pages.add(f);
		for (int i = 1; i <= maxPage; i++) {
			Page p = new Page();
			if (i == page) {
				p.setFlag(flag);
				p.setStyle("class=\"active\"");
				p.setContent(i + "");
				p.setPageNum(page);
			} else {
				p.setFlag(flag);
				p.setContent("");
				p.setContent(i + "");
				p.setPageNum(i);
			}
			pages.add(p);
		}
		f = new Page();
		f.setContent("下一页");
		if (page + 1 < maxPage) {
			f.setPageNum(page + 1);
		} else {
			f.setPageNum(maxPage);
		}

		f.setStyle("");
		f.setFlag(flag);
		pages.add(f);
		return pages;
	}

	// 根据输入自动补全
	@RequestMapping(value = "/auToList.action", method = RequestMethod.GET)
	public void auToList(HttpServletResponse response, String str) {
		String result = JSON.toJSONString(questionService.getAuToList(str));
		out(response, result);
	
	}


}
