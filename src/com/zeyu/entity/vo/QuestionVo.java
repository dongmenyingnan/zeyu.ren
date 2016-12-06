package com.zeyu.entity.vo;

import java.util.List;

import com.zeyu.entity.Question;

public class QuestionVo {
	@Override
	public String toString() {
		return "QuestionVo [question=" + question + ", answer_number=" + answer_number + ", labels=" + labels + "]";
	}
	private Question question;
	private Integer answer_number;
	private List<String> labels;
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<String> getLabels() {
		return labels;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Integer getAnswer_number() {
		return answer_number;
	}
	public void setAnswer_number(Integer answer_number) {
		this.answer_number = answer_number;
	}
	
}
