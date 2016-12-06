package com.zeyu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_articleshow", catalog = "zeyu")
public class ArticleShow {

private static final long serialVersionUID = -1136683596931703107L;
	
	private Integer articleshow_id;

	private String articleshow_content;

	private Integer article_id;

	private Integer user_id;
	
	private Date create_time;
	
	private Integer articleshow_votes;
	
	private Integer recommend;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "articleshow_id", unique = true, nullable = false)
	public Integer getArticleshow_id() {
		return articleshow_id;
	}

	public void setArticleshow_id(Integer articleshow_id) {
		this.articleshow_id = articleshow_id;
	}

	public String getArticleshow_content() {
		return articleshow_content;
	}
	@Column(name = "articleshow_content", nullable = true)
	public void setArticleshow_content(String articleshow_content) {
		this.articleshow_content = articleshow_content;
	}
	@Column(name = "article_id", nullable = true)
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	@Column(name = "user_id", nullable = true)
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Column(name = "create_time", nullable = true)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Column(name = "articleshow_votes", columnDefinition = "int default 0")
	public Integer getArticleshow_votes() {
		return articleshow_votes;
	}

	public void setArticleshow_votes(Integer articleshow_votes) {
		this.articleshow_votes = articleshow_votes;
	}
	@Column(name = "recommend", columnDefinition = "int default 0")
	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	
	
	
}
