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
@Table(name = "t_question", catalog = "zeyu")
public class Question implements Serializable {
	private static final long serialVersionUID = -166566598099192428L;

	private Integer question_id;

	private String question_comment;

	private String question_label;

	private String comment_addition;

	private Integer user_id;

	private Integer anonymous;

	private Date create_time;

	private Integer hits;

	private Integer attentions;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id", unique = true, nullable = true)
	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	@Column(name = "question_comment", nullable = true, length = 50)
	public String getQuestion_comment() {
		return question_comment;
	}

	public void setQuestion_comment(String question_comment) {
		this.question_comment = question_comment;
	}
	
	public void setQuestion_label(String question_label) {
		this.question_label = question_label;
	}
	@Column(name = "question_label")
	public String getQuestion_label() {
		return question_label;
	}
	

	@Column(name = "comment_addition", nullable = false)
	public String getComment_addition() {
		return comment_addition;
	}

	public void setComment_addition(String comment_addition) {
		this.comment_addition = comment_addition;
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

	@Column(name = "anonymous", nullable = true)
	public Integer getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}

	@Column(name = "hits", nullable = true, columnDefinition = "INT default 0")
	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	@Column(name = "attentions", nullable = true, columnDefinition = "INT default 0")
	public Integer getAttentions() {
		return attentions;
	}

	public void setAttentions(Integer attentions) {
		this.attentions = attentions;
	}

}
