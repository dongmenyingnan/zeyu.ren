package com.zeyu.entity.vo;

import java.util.List;

import com.zeyu.entity.Article;


public class ArticleVO {
	private Article article;
	private Integer article_number;
	private List<String> labels;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getArticle_number() {
		return article_number;
	}
	public void setArticle_number(Integer article_number) {
		this.article_number = article_number;
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
}
