package com.zeyu.entity.vo;
import java.util.Date;

import com.zeyu.entity.Answer;
public class AnswerGather {
	private Answer answer;
	private String username;
	private String usertype;
	private Date answer_time;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Date getAnswer_time() {
		return answer_time;
	}

	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}
