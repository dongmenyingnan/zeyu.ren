package com.zeyu.service;



import com.zeyu.entity.ArticleShow;

import com.zeyu.entity.vo.ArticleShowVo;

public interface ArticleShowService {
	public ArticleShowVo getArticleShowVo(Integer article_id);
	
	public void reply(ArticleShow articleShow);
	
	public ArticleShow getArticleShowByID(Integer article_id);
	
}
