package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.QuestionbankDao;
import com.zeyu.entity.Questionbank;

@Repository("questionbankDao")
public class QuestionbankDaoImpl  extends BaseDaoImpl<Questionbank> implements QuestionbankDao{
	public QuestionbankDaoImpl(){
		super(Questionbank.class);
	}
}
