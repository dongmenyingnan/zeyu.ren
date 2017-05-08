package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ManualArticleDao;
import com.zeyu.entity.ManualArticle;

@Repository("manualArticle")
public class ManualArticleDaoImpl extends BaseDaoImpl<ManualArticle> implements ManualArticleDao{
	public ManualArticleDaoImpl(){
		super(ManualArticle.class);
	}

}
