package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Answer;
import com.zeyu.entity.Question;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.ArticleVO;
import com.zeyu.entity.vo.QuestionVo;

public interface QuestionService {
	/*提问*/
	public void ask(Question question);
	public void askhits(hitsCollect hit);
	/*获取所有QuestionVo*/
	public List<QuestionVo> getAllQuestion();
	/*增加点击量*/
	public void hits(Integer question_id);
	/*多少分钟或者天或者月或者年  前提问*/
	public String question_time(Integer question_id);
	
	public Question getQuestionById(int question_id);
	public QuestionVo getQuestionVoByQuestionId(int question_id);
	
	public boolean updateAttentions(int question_id);
	public int getQuestionCount();
	public int getQuestionCountByUserId(int user_id);
	public int getFilterQuestionCount(String filterContent);
	public List<QuestionVo> getQuestionByPage(int kind,int page);
	public List<QuestionVo> getFilterQuestionByPage(int kind,int page,String filterContent);
	public List<QuestionVo> getSearchQuestionByPage(int kind,int page,String filterContent);
	public List<Question>  getQuestionsByUserId(int user_id);
	public List<Question>  getPageQuestionsByUserId(int user_id,int page);
	public List<String> getAuToList(String str);
	
	public boolean hitsCheck(int question_id,Integer user_id);
	public boolean delete(String user_id);
	

}
