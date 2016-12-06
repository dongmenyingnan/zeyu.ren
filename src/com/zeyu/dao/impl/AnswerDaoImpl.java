package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.AnswerDao;
import com.zeyu.entity.Answer;

@Repository("answerDao")
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao{
	public AnswerDaoImpl(){
		super(Answer.class);
	}
}
