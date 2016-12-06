package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.QuestionDao;
import com.zeyu.entity.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao{
	public QuestionDaoImpl(){
		super(Question.class);
	}
}
