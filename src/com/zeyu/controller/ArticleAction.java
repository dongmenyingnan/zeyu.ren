package com.zeyu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zeyu.entity.Answer;
import com.zeyu.entity.Article;
import com.zeyu.entity.ArticleShow;
import com.zeyu.entity.Page;
import com.zeyu.entity.RequestFlag;
import com.zeyu.entity.User;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.AnswerVo;
import com.zeyu.entity.vo.ArticleShowVo;
import com.zeyu.entity.vo.ArticleVO;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.ArticleService;
import com.zeyu.service.ArticleShowService;
import com.zeyu.service.QuestionService;

@Controller
public class ArticleAction extends BaseAction {

	@Autowired
	ArticleService articleService;

	@Autowired
	ArticleShowService articleShowService;
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/allArticles.action", method = RequestMethod.GET)
	public String getAllArticles(HttpSession session, Model model, Integer flag, Integer page) {
		// 默认显示最新的文章列表
		// 默认显示最新的文章列表
//		List<Article> articlesNew = articleService.getAllArticles(1);
//		model.addAttribute("articlesNew", articlesNew);
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{

		RequestFlag requestFlag = new RequestFlag();
		if (flag == null || flag == 1) {
			requestFlag.setMostNew("class=\"active\"");
			requestFlag.setMostHot("");
			requestFlag.setActiveHot("");
			requestFlag.setActiveNew("active");
		}
		model.addAttribute("requestFlag", requestFlag);

		List<Page> pages = new ArrayList<>();
		int size = articleService.getArticleCount();
		int maxPage = (int) Math.ceil(1.0 * size / 10);
		if (page == null || page < 1) {
			page = 1;
		} else if (page >= maxPage) {
			page = maxPage;
		}
		pages = getPages(page, maxPage, 1);
	
		List<ArticleVO> ArticleVO = new ArrayList<ArticleVO>();
		
		ArticleVO = articleService.getArticleByPage(2, page); 
		
		
		model.addAttribute("articles", ArticleVO);
		
		model.addAttribute("PagesNew", pages);

		return "article";
		}

	}

	@RequestMapping(value = "/showArticlesByUserKind.action")
	public String showArticlesByUserKind(Model model, Integer flag, Integer page,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		List<Article> lists = articleService.showArticlesByUserKind(1);
		model.addAttribute("articlesGrade", lists);

		RequestFlag requestFlag = new RequestFlag();
		if (flag == null || flag == 1) {
			requestFlag.setMostNew("");
			requestFlag.setMostHot("class=\"active\"");
			requestFlag.setActiveHot("active");
			requestFlag.setActiveNew("");
		}
		model.addAttribute("requestFlag", requestFlag);
		List<Page> pages = new ArrayList<>();
		int size = articleService.getArticleCount();

		int maxPage = (int) Math.ceil(1.0 * size / 10);
		if (page == null || page < 1) {
			page = 1;
		} else if (page >= maxPage) {
			page = maxPage;
		}
		pages = getPages(page, maxPage, 1);
		System.out.println(pages.toString() + "+++" + pages.size());
		model.addAttribute("PagesNew", pages);
		return "article";
		}
	}

	@RequestMapping(value = "/searchArticles.action")
	public String searchArticles(Model model, Integer page, Integer flag, String keyword) {
		if(keyword==null)
			keyword="a";
		System.out.println(keyword+"keyword");
//		List<Article> lists = articleService.searchArticles(page, keyword);
//		
//		System.out.println("++++++++++++++++++++" + lists.toString());
//		model.addAttribute("articles", lists);

		RequestFlag requestFlag = new RequestFlag();
		if (flag == null || flag == 1) {
			requestFlag.setMostNew("class=\"active\"");
			requestFlag.setMostHot("");
			requestFlag.setActiveHot("");
			requestFlag.setActiveNew("active");
		}
		model.addAttribute("requestFlag", requestFlag);
		List<Page> pages = new ArrayList<>();
		
		int size = articleService.getFilterArticleCount(keyword);

		int maxPage = (int) Math.ceil(1.0 * size / 10);
		if (page == null || page < 1) {
			page = 1;
		} else if (page >= maxPage) {
			page = maxPage;
		}
		pages = getPages(page, maxPage, 1);
		
		List<ArticleVO> ArticleVO = new ArrayList<ArticleVO>();
		//s即为字符串去掉空格之后的文字。searchContent为输入的全部信息
		ArticleVO = articleService.getFilterArticleByPage(1, page, keyword);

		model.addAttribute("articles", ArticleVO);
		
		model.addAttribute("PagesNew", pages);
		return "article";
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
	@RequestMapping(value = "/auToListArticles.action", method = RequestMethod.GET)
	public void auToList(HttpServletResponse response, String str,Integer page,Integer flag) {
		String result = JSON.toJSONString(articleService.getAuToListArticles(str));
		out(response, result);
	}
	@RequestMapping(value="/article.action",method =RequestMethod.GET)
	
	public String article(Model model, Integer article_id,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(article_id==null){
			article_id=articleService.getQuestionCount()+1;
		}
		
		if(articleService.hitsCheck(article_id,user.getUser_id())){
			articleService.hits(article_id);
			hitsCollect hit = new hitsCollect();
			hit.setColl_arts_id(article_id);
			hit.setColl_user_id(user.getUser_id());
			articleService.askhits(hit);
		}
	
		ArticleShowVo articleVo =  new ArticleShowVo();
		articleVo = articleShowService.getArticleShowVo(article_id);
		articleVo.setArticle_time(articleService.article_time(article_id));
		model.addAttribute("articleVo", articleVo);
		
		return "articleshow";
	}
	@RequestMapping(value="/replyArticle.action")
	public String reply(Model model,String article_content,Integer article_id,HttpSession session ){
		
		User user =(User) session.getAttribute("user");
		if(user==null){
			
			return "redirect:./user/account.jsp";
				
		}
		
		Date create_time =new  Date();
		ArticleShow articleShow = new ArticleShow();
		articleShow.setArticleshow_content(article_content);
		articleShow.setCreate_time(create_time);
		articleShow.setArticle_id(article_id);
		articleShow.setUser_id(user.getUser_id());
		articleShowService.reply(articleShow);
		return "redirect:/article.action?article_id=" + article_id;
	}
	@RequestMapping(value="/addArticleVotes.action")
	public void  addVotes(String json, HttpServletResponse response,String answer_id){
		ArticleShow articleshow=articleShowService.getArticleShowByID(Integer.parseInt(answer_id));
		articleshow.setArticleshow_votes(articleshow.getArticleshow_votes()+1);
		String result = JSON.toJSONString("success");
		out(response, result);
	}
	
	
}
