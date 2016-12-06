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
@Table(name = "t_answer", catalog = "zeyu")
public class Answer implements Serializable {
	
	private static final long serialVersionUID = -1136683596931703107L;
	
	private Integer answer_id;

	private String answer_content;

	private Integer question_id;

	private Integer user_id;
	
	private Date create_time;
	
	private Integer answer_votes;
	
	private Integer recommend;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id", unique = true, nullable = false)
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	
	@Column(name = "recommend", columnDefinition = "int default 0")
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	@Column(name = "answer_votes", columnDefinition = "int default 0")
	public Integer getAnswer_votes() {
		return answer_votes;
	}
	
	public void setAnswer_votes(Integer answer_votes) {
		this.answer_votes = answer_votes;
	}
	
	@Column(name = "answer_content", nullable = true)
	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	@Column(name = "question_id", nullable = true)
	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
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

}
