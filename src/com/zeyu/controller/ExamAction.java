package com.zeyu.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeyu.entity.Questionbank;
import com.zeyu.service.QuestionbankService;

@Controller
@RequestMapping(value="/teacher")
public class ExamAction {
	@Autowired
	QuestionbankService Questionbank;
	@RequestMapping(value="/upload.action")
	public void examUpload(HttpServletRequest request,HttpServletResponse response,
			   @RequestParam("file") MultipartFile file){
		
		   String que_scrope = request.getParameter("scrope");
		   String que_type= request.getParameter("type");
		   
		   String path = request.getSession().getServletContext().getRealPath("/");
		   File targetFile = new File(path, file.getOriginalFilename());
		   Questionbank questionbank = new Questionbank();
		   questionbank.setQuestionbank_course(file.getOriginalFilename());
		   questionbank.setQuestionbank_name(file.getOriginalFilename());
		   questionbank.setQuestionbank_scope(que_scrope);
		   questionbank.setQuestionbank_type(que_type);
		   questionbank.setQuestionbank_qid((int)((Math.random()*9+1)*100000));
		   
		   Questionbank.addQustionbank(questionbank);
		   
		   if (!targetFile.exists()) {
	           targetFile.mkdirs();
	       // 保存
	       try {
	    	  file.transferTo(targetFile);
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	}
}
	@RequestMapping(value="/delete.action")
	public void deleteQuestionBank(HttpServletRequest request,HttpServletResponse response){
		String qid = request.getParameter("qid");
		Questionbank.deleteQuestionBank(qid);
		
	}

}
