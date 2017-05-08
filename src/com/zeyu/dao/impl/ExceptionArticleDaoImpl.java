package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ExceptionArticleDao;
import com.zeyu.entity.ExceptionArticle;

@Repository("exceptionArticleDao")
public class ExceptionArticleDaoImpl extends BaseDaoImpl<ExceptionArticle> implements ExceptionArticleDao{
	public ExceptionArticleDaoImpl(){
		super(ExceptionArticle.class);
	}

}
