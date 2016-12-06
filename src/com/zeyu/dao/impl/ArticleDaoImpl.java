package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ArticleDao;
import com.zeyu.entity.Article;

@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao{
	public ArticleDaoImpl(){
		super(Article.class);
	}
}
