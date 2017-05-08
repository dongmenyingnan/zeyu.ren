package com.zeyu.CMS.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zeyu.controller.BaseAction;
import com.zeyu.entity.Exception;
import com.zeyu.entity.ExceptionArticle;
import com.zeyu.service.ExceptionArticleService;

@Controller
@RequestMapping(value="/CMS/exception" )
public class CMSExceptionAction extends BaseAction{
	
	@Autowired
	ExceptionArticleService exceptionArticleService;

	@RequestMapping(value = "/exceptionList.action", method = RequestMethod.GET)
	public void questionList(String json, HttpServletResponse response) {
		String result = JSON.toJSONString(exceptionArticleService.getcateSeach(0,1));
		System.out.println(result.toString());
		out(response, result);
	}
	@RequestMapping(value = "/exceptionDeleteRole.action", method = RequestMethod.POST)
	public void adminDeleteRole(HttpServletResponse response, String id) {
		String result = exceptionArticleService.delete(id) + "";
		out(response, result);
	}
	@RequestMapping(value = "/exceptionAddRole.action", method = RequestMethod.POST)
	public void adminAddRole(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
		String article_name =request.getParameter("article_name");
		String article_author=request.getParameter("article_author");
		String article_content = request.getParameter("article_content");
		String tags_1 =request.getParameter("tags_1");
		String article_type =request.getParameter("article_type");
		System.out.println(article_name+"       "+article_author+"      "+article_content+"    "+tags_1+"      "+article_type);
		Exception exception  = new Exception();
		exception.setException_lab(tags_1);
		exception.setException_name(article_name);
		exception.setException_type(Integer.valueOf(article_type));
		exception.setException_url("/exceptionarticle.action");
		if(article_type.equals("1")){
			exception.setException_backgroundimg("./image/manual/backBg.png");
		}else if(article_type.equals("2")){
			exception.setException_backgroundimg("./image/manual/bigdataBg.png");
		}else if(article_type.equals("3")){
			exception.setException_backgroundimg("./image/manual/dataBg.png");
		}else if(article_type.equals("4")){
			exception.setException_backgroundimg("./image/manual/feBg.png");
		}else if(article_type.equals("5")){
			exception.setException_backgroundimg("./image/manual/imgBg.png");
		}else {
			exception.setException_backgroundimg("./image/manual/mobileBg.png");
		}
		exceptionArticleService.add(exception);
		ExceptionArticle exceptionArticle = new ExceptionArticle();
		exceptionArticle.setExceptionarticle_title(article_name);
		
		exceptionArticle.setExceptionarticle_type(article_type);
		exceptionArticle.setExceptionarticle_author(article_author);
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat fmtrq = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.CHINA);
		String nowDate = fmtrq.format(now.getTime()); 
		Date nowdate = fmtrq.parse(nowDate);
		exceptionArticle.setExceptionarticle_time(nowdate);
		exceptionArticle.setExceptionarticle_content(article_content);
		exceptionArticle.setUuid(exception.getException_id());
		exceptionArticleService.adddata(exceptionArticle);
		
	}

	
}
