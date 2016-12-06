package com.zeyu.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.zeyu.entity.Article;
import com.zeyu.entity.ArticleShow;


public class ArticleShowVo {
	private Article article;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<ArticleShowGather> getArticleshowGathers() {
		return articleshowGathers;
	}
	public void setArticleshowGathers(List<ArticleShowGather> articleshowGathers) {
		this.articleshowGathers = articleshowGathers;
	}
	private List<ArticleShowGather> articleshowGathers = new ArrayList<ArticleShowGather>();
	private String article_time;
	private String user_name;

	public String getArticle_time() {
		return article_time;
	}
	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
}
