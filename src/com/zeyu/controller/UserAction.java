package com.zeyu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeyu.entity.Article;
import com.zeyu.entity.Collection;
import com.zeyu.entity.FeedBack;
import com.zeyu.entity.History;
import com.zeyu.entity.Page;
import com.zeyu.entity.Question;
import com.zeyu.entity.Questionbank;
import com.zeyu.entity.User;
import com.zeyu.entity.vo.ArticleVO;
import com.zeyu.entity.vo.Attention;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.ArticleService;
import com.zeyu.service.CollectionService;
import com.zeyu.service.HistoryService;
import com.zeyu.service.QuestionService;
import com.zeyu.service.QuestionbankService;
import com.zeyu.service.UserService;
import com.zeyu.util.MyMail;

@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction {

	@Autowired
	UserService userService;
	@Autowired
	HistoryService historyService;
	@Autowired
	CollectionService collectionService;
	@Autowired
	QuestionService questionService;
	@Autowired
	ArticleService articleService;
	@Autowired
	QuestionbankService questionBankService;

	@RequestMapping("/settings.action")
	public String redis(){
		return "settings";
	}
	
	// 注册
	//没有用户名唯一性的判断
	@RequestMapping(value = "/register.action", method = RequestMethod.POST)
	public String register(Model model, String user_id, String user_name, String user_email, String user_pass,
			String user_pass_con) {
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_email(user_email);
		user.setUser_pass(user_pass);
		user.setUser_kind(1);
		user.setUser_type("学生");
		userService.add(user);

		return "account";
	}

	// 手机验证码登录
	@RequestMapping(value = "phoneLogin.action", method = RequestMethod.POST)
	public void phoneLogin(HttpServletResponse response, HttpSession session, String user_tele) {
		System.out.println(user_tele);
		User user = null;
		if (user_tele != null)
			user = userService.findByTele(user_tele);
		if (user != null) {
			System.out.println("登录成功");
			session.setAttribute("user", user);
		} else {
			System.out.println("登录失败");
		}
		String result = "true";
		out(response, result);
	}

	// 登录
	@RequestMapping(value = "/login.action")
//	, method = RequestMethod.POST
	public String login(HttpSession session, Model model, String user_name, String user_pass) {
		User userLogin = new User();
		userLogin.setUser_name(user_name);
		userLogin.setUser_pass(user_pass);
		
		User user = userService.judge(userLogin);
		if (user != null) {
			System.out.println("登录成功");
			session.setAttribute("user", user);
			if (user.getUser_kind() == 0)
				return "redirect:../CMS/index.html";
			else
				return "redirect:/home.action";

		} else {
			session.setAttribute("user", null);
			System.out.println("登录失败");
			return "account";
		}

	}
	@RequestMapping(value="/admincheck.action",method=RequestMethod.POST)
	public void admincheck(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		User user = (User)session.getAttribute("user");
		try {
			if(user==null){
				response.getWriter().print("null");	
			}else if(String.valueOf(user.getUser_id()).equals("18")){
				response.getWriter().print("1");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 忘记密码 发送邮件 找回密码
	//重置有问题
	@RequestMapping(value = "/fogertPass.action", method = RequestMethod.POST)
	public void forgetPass(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		String user_email= request.getParameter("email");
		User user=userService.findByEmail(user_email);
		String user_token = getRandomString(20);
		user.setUser_token(user_token);
		user.setUser_token_status("0");
		userService.update(user);
		
		if(user==null){
			
		}else{
			
		session.setAttribute("user", user);
		String resetPassUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/user/resetPassView.action?token="+user_token;
		String smtp = "smtp.126.com";
		String from = "just_domyself@126.com";
		String to = user_email;
		String subject = "Reset Your Password";
		String content = "</br>" + "<a href=" + resetPassUrl + ">"
				+ "Please click link address to reset your password</a></br>";

		String username = "just_domyself";
		String password = "LS_insiston_LS";
		boolean flag= MyMail.send(smtp, from, to, subject, content, username, password);
		if(flag==true){
			response.getWriter().print("1");	
		}else{
			response.getWriter().print("0");
			}
		}
	}
	@RequestMapping(value="/resetPassView.action",method = RequestMethod.GET)
	public String resetPassView(String token,Model model){
		User user= userService.findByUserToken(token);
		String stutas= user.getUser_token_status();
		if(stutas.equals("0")){
			user.setUser_token_status("1");
			userService.update(user);
			model.addAttribute("user_id", user.getUser_name());
			return "resetPass";
		}else {
			return "invalid";
		}
		
		
	}

	//重置密码用户token生成
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  
	
	// 忘记密码 根据邮件内容更新密码
	@RequestMapping(value = "/resetPass.action", method = RequestMethod.POST)
	public String resetPass(HttpSession session, Model model, String user_pass, String user_pass_con,String user_id) {
		User user= userService.findByUser(user_id).get(0);
		if (user != null)
			System.out.println(user.toString());

		else
			System.out.println("user为空");
		if (user_pass.equals(user_pass_con))
			user.setUser_pass(user_pass);
			userService.update(user);
		return "account";
	}
	@RequestMapping(value ="/settings_check.action")
	public String settings_check(HttpSession session,Model model){
		User user  =(User) session.getAttribute("user");
		
		if(user.getUser_kind()==1){
			System.out.println("学生");
		}else{
			model.addAttribute("uploadfage", user);
		}
		
		return "settings";
	}
	@RequestMapping(value="/uploadTest.action")
	public String uploadTest(HttpSession session, Model model, Integer page, Integer flag){
	
		try {
			List<Page> pages = new ArrayList<>();
			List<Integer> size = questionBankService.getQuestionBankCount();
			for (int a =0;a<size.size();a++){
				int maxPage = (int) Math.ceil(1.0 * size.get(a) / 10);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage) {
					page = maxPage;
				}
				pages = getPages(page, maxPage, 1);
				model.addAttribute("PagesNew"+a, pages);
				
			}
			
			
			// 最热问题列表
			List<List<Questionbank>> questionbank = new ArrayList<List<Questionbank>>();
			
			questionbank = questionBankService.getQuestionBankByPage(page); 
			
			for(int i =0; i<questionbank.size();i++){
					model.addAttribute("questionsNew"+i, questionbank.get(i));
			}
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../teacher/uploadTest";
	}

	@RequestMapping(value="/ajaxupload.action")
	public String ajaxupload(HttpServletRequest request, HttpSession session, Model model, Integer page, Integer flag){
			String scope = request.getParameter("scope");
			model.addAttribute("scope", scope);
		try {
			List<Page> pages = new ArrayList<>();
			List<Integer> size = questionBankService.getQuestionBankCount();
			for (int a =0;a<size.size();a++){
				int maxPage = (int) Math.ceil(1.0 * size.get(a) / 10);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage) {
					page = maxPage;
				}
				pages = getPages(page, maxPage, 1);
				model.addAttribute("PagesNew"+a, pages);
				
			}
			
			
			// 最热问题列表
			List<List<Questionbank>> questionbank = new ArrayList<List<Questionbank>>();
			
			questionbank = questionBankService.getQuestionBankByPage(page); 
			
			for(int i =0; i<questionbank.size();i++){
					model.addAttribute("questionsNew"+i, questionbank.get(i));
			}
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../ajax/AjaxQuestionUpload";
	}
	// 更新个人信息 settting.jsp
	@RequestMapping(value = "/settings.action", method = RequestMethod.POST)
	public String setting(HttpSession session, Model model, String user_name, String user_id, String user_sex,
			String user_per_web, String user_cha_web, String user_birth, String user_intro) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setUser_name(user_name);
			user.setUser_per_web(user_per_web);
			user.setUser_cha_web(user_cha_web);
			user.setUser_intro(user_intro);
			userService.update(user);
		}
		return "account";
	}

	// 上传头像

	// 我的 搜索记录
	@RequestMapping(value = "/mySearchRecords.action", method = RequestMethod.GET)
	public String mySearchRecords(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<History> historys = historyService.querySearch("history_user_id='" + user.getUser_id() + "'");
			model.addAttribute("historys", historys);
		}
		return "mySearchRecords";
	}

	// 用户添加收藏
	@RequestMapping(value = "/addCollection.action", method = RequestMethod.POST)
	public String addCollection(Model model, HttpSession session, int question_id) {
		User user = (User) session.getAttribute("user");
		if (!collectionService.isAttention(user.getUser_id(), question_id)) {
			Collection collection = new Collection();
			collection.setColl_ques_id(question_id);
			collection.setColl_kind(1);
			collection.setColl_user_id(user.getUser_id());
			collectionService.add(collection);
		}

		return "redirect:/answers.action?question_id=" + question_id;
	}

	// 用户添加关注
	@RequestMapping(value = "/addAttention.action", method = RequestMethod.POST)
	public String addAttention(Model model, HttpSession session, int question_id) {
		User user = (User) session.getAttribute("user");
		// 关注之前判断是否已经关注过，如果没有关注过才可以关注
		if (user == null) {
			return "redirect:../user/account.jsp";
		}
		if (!collectionService.isAttention(user.getUser_id(), question_id)) {
			Collection collection = new Collection();
			collection.setColl_ques_id(question_id);
			collection.setColl_kind(2);
			collection.setColl_user_id(user.getUser_id());
			collectionService.add(collection);
			questionService.updateAttentions(question_id);
		}

		return "redirect:/answers.action?question_id=" + question_id;
	}
	
	
	@RequestMapping(value = "/addAttentionArticle.action", method = RequestMethod.POST)
	public String addAttentionarticle(Model model, HttpSession session, int article_id) {
		User user = (User) session.getAttribute("user");
		// 关注之前判断是否已经关注过，如果没有关注过才可以关注
		if (user == null) {
			return "redirect:../user/account.jsp";
		}
		if (!collectionService.isAttentionArticle(user.getUser_id(), article_id)) {
			Collection collection = new Collection();
			collection.setColl_art_id(article_id);
			collection.setColl_kind(1);
			collection.setColl_user_id(user.getUser_id());
			collectionService.add(collection);
			articleService.updateAttentions(article_id);
		}

		return "redirect:/article.action?article_id=" + article_id;
	}

	// 查看我的收藏
	@RequestMapping(value = "/showMyCollection.action", method = RequestMethod.GET)
	public String showMyCollection(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		List<Collection> collections = collectionService.getMyCollection(user.getUser_id(), 1);
		
		List<Attention> attentions = new ArrayList<Attention>();
		for (int i = 0; i < collections.size(); i++) {
			Attention attention = new Attention();
			ArticleVO articleVo = articleService.getArticleVoByArticleId(collections.get(i).getColl_art_id());
			attention.setNum(i);
			if (articleVo != null) {
				
				attention.setTitle(articleVo.getArticle().getArticle_name());
				attention.setReadNum(articleVo.getArticle().getHits());
				attention.setAttenNum(articleVo.getArticle().getAttentions());
				attention.setAnsNum(articleVo.getArticle_number());
				

			}
			attentions.add(attention);
		}
		
		model.addAttribute("attentions", attentions);
		return "favorites";
		}
	}

	// 查看我的关注
	@RequestMapping(value = "/showMyAttention.action", method = RequestMethod.GET)
	public String showMyAttention(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
		List<Collection> collections = collectionService.getMyCollection(user.getUser_id(), 2);
		
		List<Attention> attentions = new ArrayList<Attention>();
		
		
		for (int i = 0; i < collections.size(); i++) {
			Attention attention = new Attention();
			
			QuestionVo questionVo = questionService.getQuestionVoByQuestionId(collections.get(i).getColl_ques_id());
			System.out.println(i);
			System.out.println(collections.get(i).getColl_ques_id());
			attention.setNum(i);
		
			if (questionVo != null) {
				
				attention.setTitle(questionVo.getQuestion().getQuestion_comment());
				attention.setReadNum(questionVo.getQuestion().getHits());
				attention.setAttenNum(questionVo.getQuestion().getAttentions());
				attention.setAnsNum(questionVo.getAnswer_number());

			}
			
			
			attentions.add(attention);
		
		}

		model.addAttribute("attentions", attentions);
	
		return "following";
		}
	}

	// 用户反馈
	@RequestMapping(value = "/feedBack.action", method = RequestMethod.POST)
	public String feedback(Model model, HttpSession session, String contact, String content) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:../user/account.jsp";
		}
		FeedBack feedBack = new FeedBack();
		feedBack.setFeed_user_id(user.getUser_id());
		feedBack.setFeed_user_contact(contact);
		feedBack.setFeed_user_content(content);
		userService.feedBack(feedBack);
		return "redirect:/home.action";
	}
	
	@RequestMapping(value="/write.action",method=RequestMethod.POST)
	public String write(HttpSession session,String article_name,String article_content,String article_tag){
		Article article=new Article();
		article.setArticle_name(article_name);
		article.setArticle_tag(article_tag);
		article.setArticle_content(article_content);
		article.setArticle_time(new Date());
		User user=(User) session.getAttribute("user");
		article.setArticle_user_id(user.getUser_id());
		article.setArticle_id(1);
		article.setAttentions(0);
		articleService.write(article);
		return "redirect:/allArticles.action";
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

	
}
