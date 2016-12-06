package com.zeyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_feedback", catalog = "zeyu")
public class FeedBack implements Serializable {
	
	
	private static final long serialVersionUID = -8879368467091086765L;
	private Integer feed_user_id;
	private String feed_user_contact;
	private String feed_user_content;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feed_user_id", unique = true, nullable = true)
	public Integer getFeed_user_id() {
		return feed_user_id;
	}

	public void setFeed_user_id(Integer feed_user_id) {
		this.feed_user_id = feed_user_id;
	}
	@Column(name = "feed_user_contact")
	public String getFeed_user_contact() {
		return feed_user_contact;
	}

	public void setFeed_user_contact(String feed_user_contact) {
		this.feed_user_contact = feed_user_contact;
	}
	@Column(name = "feed_user_content")
	public String getFeed_user_content() {
		return feed_user_content;
	}

	public void setFeed_user_content(String feed_user_content) {
		this.feed_user_content = feed_user_content;
	}

}
