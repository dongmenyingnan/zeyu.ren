package com.zeyu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_article", catalog = "zeyu")
public class Article implements Serializable {

	/**
	 * 文章实体
	 */
	private static final long serialVersionUID = 4753028978276406850L;
	private Integer article_id;
	private String article_name;
	private String article_content;
	private String article_tag;
	private Integer article_user_id;
	private Integer article_user_kind;
	private Date article_time;
	private Integer hits;
	private Integer attentions;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id", unique = true, nullable = true)
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	
	public void setArticle_user_kind(Integer article_user_kind) {
		this.article_user_kind = article_user_kind;
	}
	@Column(name = "attentions", nullable = true, columnDefinition = "INT default 0")
	public Integer getAttentions() {
		return attentions;
	}

	public void setAttentions(Integer attentions) {
		this.attentions = attentions;
	}
	@Column(name = "article_user_kind", nullable = false)
	public Integer getArticle_user_kind() {
		return article_user_kind;
	}
	@Column(name = "article_name", nullable = true)
	public String getArticle_name() {
		return article_name;
	}

	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	@Column(name = "article_content", nullable = true)
	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	@Column(name = "article_tag", nullable = true)
	public String getArticle_tag() {
		return article_tag;
	}

	public void setArticle_tag(String article_tag) {
		this.article_tag = article_tag;
	}
	@Column(name = "article_user_id", nullable = false)
	public Integer getArticle_user_id() {
		return article_user_id;
	}

	public void setArticle_user_id(Integer article_user_id) {
		this.article_user_id = article_user_id;
	}
	@Column(name = "article_time", nullable = true)
	public Date getArticle_time() {
		return article_time;
	}

	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}
	
	@Column(name = "hits", nullable = true, columnDefinition = "INT default 0")
	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}


	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", article_name=" + article_name + ", article_content="
				+ article_content + ", article_tag=" + article_tag + ", article_user_id=" + article_user_id
				+ ", article_time=" + article_time + "]";
	}

	

}
