package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Questionbank;

public interface QuestionbankService {

	void addQustionbank(Questionbank questionbank);
	
	public List<Integer> getQuestionBankCount();
	
	public List<List<Questionbank>> getQuestionBankByPage(int page);
	
	public void deleteQuestionBank(String qid);

}
