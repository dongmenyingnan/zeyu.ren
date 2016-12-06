package com.zeyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_questionbank", catalog = "zeyu")
public class Questionbank {
	
	private static final long serialVersionUID = -166566598099192428L;
	
	private Integer questionbank_id;
	
	private Integer  questionbank_qid;
	
	private String  questionbank_name;
	
	private String questionbank_type;
	
	private String questionbank_scope;
	
	private String questionbank_course;

	@Override
	public String toString() {
		return "Questionbank [questionbank_id=" + questionbank_id + ", questionbank_qid=" + questionbank_qid
				+ ", questionbank_name=" + questionbank_name + ", questionbank_type=" + questionbank_type
				+ ", questionbank_scope=" + questionbank_scope + ", questionbank_course=" + questionbank_course + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionbank_id", unique = true, nullable = true)
	public Integer getQuestionbank_id() {
		return questionbank_id;
	}

	public void setQuestionbank_id(Integer questionbank_id) {
		this.questionbank_id = questionbank_id;
	}
	@Column(name = "questionbank_qid", nullable = true)
	public Integer getQuestionbank_qid() {
		return questionbank_qid;
	}

	public void setQuestionbank_qid(Integer questionbank_qid) {
		this.questionbank_qid = questionbank_qid;
	}
	@Column(name = "questionbank_name", nullable = true)
	public String getQuestionbank_name() {
		return questionbank_name;
	}

	public void setQuestionbank_name(String questionbank_name) {
		this.questionbank_name = questionbank_name;
	}
	@Column(name = "questionbank_type", nullable = true)
	public String getQuestionbank_type() {
		return questionbank_type;
	}

	public void setQuestionbank_type(String questionbank_type) {
		this.questionbank_type = questionbank_type;
	}
	@Column(name = "questionbank_scope", nullable = true)
	public String getQuestionbank_scope() {
		return questionbank_scope;
	}

	public void setQuestionbank_scope(String questionbank_scope) {
		this.questionbank_scope = questionbank_scope;
	}
	@Column(name = "questionbank_course", nullable = true)
	public String getQuestionbank_course() {
		return questionbank_course;
	}

	public void setQuestionbank_course(String questionbank_course) {
		this.questionbank_course = questionbank_course;
	}
	
	

}
