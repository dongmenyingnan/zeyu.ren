package com.zeyu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.QuestionbankDao;
import com.zeyu.entity.Question;
import com.zeyu.entity.Questionbank;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.QuestionbankService;
@Service("questionbankService")
public class QuestionbankServiceImpl implements QuestionbankService{
	@Resource	
	QuestionbankDao questionbankDao;
	
		
	


	@Override
	public void addQustionbank(Questionbank questionbank) {
		// TODO Auto-generated method stub
		
		questionbankDao.add(questionbank);
	}
	@Override
	public List<Integer> getQuestionBankCount() {
		// TODO Auto-generated method stub
		return questionbankDao.findCountQuestionBank();
	}
	@Override
	public List<List<Questionbank>> getQuestionBankByPage(int page) {
		// TODO Auto-generated method stub
		List<List<Questionbank>> listquestionbanks= new ArrayList<List<Questionbank>>();
		List<Questionbank> questionbanks = new ArrayList<Questionbank>();
		listquestionbanks.clear();
		questionbanks.clear();
		for(int a=0;a<3;a++){
			questionbanks=questionbankDao.findBankConditionByPage(page,"questionbank_scope="+a);
			listquestionbanks.add(questionbanks);
		}
		return listquestionbanks;
	

	
	}
	@Override
	public void deleteQuestionBank(String qid) {
		try {
			questionbankDao.deleteByIds("questionbank_qid="+qid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
