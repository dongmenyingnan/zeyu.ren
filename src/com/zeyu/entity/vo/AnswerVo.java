package com.zeyu.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.zeyu.entity.Question;

public class AnswerVo {
	private Question question;
	private List<AnswerGather> answerGathers = new ArrayList<AnswerGather>();
	private String question_time;
	private String user_name;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getQuestion_time() {
		return question_time;
	}

	public void setQuestion_time(String question_time) {
		this.question_time = question_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<AnswerGather> getAnswerGathers() {
		return answerGathers;
	}

	public void setAnswerGathers(List<AnswerGather> answerGathers) {
		this.answerGathers = answerGathers;
	}
}
