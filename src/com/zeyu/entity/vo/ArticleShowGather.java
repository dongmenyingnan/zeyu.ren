package com.zeyu.entity.vo;

import java.util.Date;

import com.zeyu.entity.Article;
import com.zeyu.entity.ArticleShow;

public class ArticleShowGather {
	private ArticleShow articleshow;
	public ArticleShow getArticleshow() {
		return articleshow;
	}
	public void setArticleshow(ArticleShow articleshow) {
		this.articleshow = articleshow;
	}
	private String username;
	private String usertype;
	private Date article_time;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Date getArticle_time() {
		return article_time;
	}
	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}
	
	
}
