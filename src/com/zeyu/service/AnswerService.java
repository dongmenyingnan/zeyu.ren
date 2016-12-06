package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Answer;
import com.zeyu.entity.vo.AnswerVo;

public interface AnswerService {
	/*回答*/
	public void reply(Answer answer);
	/*根据问题id获取AnswerVo*/
	public AnswerVo getAnswerVo(Integer question_id);
	
	public int getAnswerCount();
	public Integer getAnswerCountByUserId(int user_id);
	public List<Answer>  getAnswersByUserId(int user_id);
	public List<Answer>  getPageAnswersByUserId(int user_id,int page);
	public Answer getAnswerByID(Integer answer_id);
	public void updateAnswer(Answer answer);
	
}
