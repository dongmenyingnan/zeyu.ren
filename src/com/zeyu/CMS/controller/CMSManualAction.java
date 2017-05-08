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
import com.zeyu.entity.Manual;
import com.zeyu.entity.ManualArticle;
import com.zeyu.service.ManualService;

@Controller
@RequestMapping("/CMS/manual")
public class CMSManualAction extends BaseAction{
	@Autowired
	ManualService manualServlce;
	
	
	@RequestMapping(value = "/manualList.action", method = RequestMethod.GET)
	public void questionList(String json, HttpServletResponse response) {
		String result = JSON.toJSONString(manualServlce.getcateSeach(0,1));
		out(response, result);
	}
	@RequestMapping(value = "/manualDeleteRole.action", method = RequestMethod.POST)
	public void adminDeleteRole(HttpServletResponse response, String id) {
		String result = manualServlce.delete(id) + "";
		out(response, result);
	}
	@RequestMapping(value = "/manualAddRole.action", method = RequestMethod.POST)
	public void adminAddRole(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
		String article_name =request.getParameter("article_name");
		String article_author=request.getParameter("article_author");
		String article_content = request.getParameter("article_content");
		String tags_1 =request.getParameter("tags_1");
		String article_type =request.getParameter("article_type");
		System.out.println(article_name+"       "+article_author+"      "+article_content+"    "+tags_1+"      "+article_type);
		Manual manual = new Manual();
		manual.setManual_lab(tags_1);
		manual.setManual_name(article_name);
		manual.setManual_type(Integer.valueOf(article_type));
		manual.setManual_url("/manualarticle.action");
		if(article_type.equals("1")){
			manual.setManual_backgroundimg("./image/manual/backBg.png");
		}else if(article_type.equals("2")){
			manual.setManual_backgroundimg("./image/manual/bigdataBg.png");
		}else if(article_type.equals("3")){
			manual.setManual_backgroundimg("./image/manual/dataBg.png");
		}else if(article_type.equals("4")){
			manual.setManual_backgroundimg("./image/manual/feBg.png");
		}else if(article_type.equals("5")){
			manual.setManual_backgroundimg("./image/manual/imgBg.png");
		}else {
			manual.setManual_backgroundimg("./image/manual/mobileBg.png");
		}
		manualServlce.add(manual);
		ManualArticle manualArticle = new ManualArticle();
		manualArticle.setManualartcle_title(article_name);
		manualArticle.setManualartcle_type(article_type);
		manualArticle.setMaualartcle_author(article_author);
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat fmtrq = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.CHINA);
		String nowDate = fmtrq.format(now.getTime()); 
		Date nowdate = fmtrq.parse(nowDate);
		manualArticle.setMaualartcle_time(nowdate);
		manualArticle.setManualartcle_content(article_content);
		manualArticle.setUuid(manual.getManual_id());
		manualServlce.adddata(manualArticle);
	
		
	}

}
