package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ArticleShowDao;
import com.zeyu.entity.ArticleShow;

@Repository("articleShowDao")
public class ArticleShowDaoImpl extends BaseDaoImpl<ArticleShow> implements ArticleShowDao{

	public ArticleShowDaoImpl() {
		super(ArticleShow.class);
		
	}

}
