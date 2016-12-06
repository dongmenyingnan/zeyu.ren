package com.zeyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_history", catalog = "zeyu")
public class History implements Serializable {

	private static final long serialVersionUID = 1830498781087904906L;
	private Integer history_id;
	private Integer history_user_id;
	private String history_time;
	private String history_kind;
	private String history_key;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "history_id", unique = true, nullable = true)
	public Integer getHistory_id() {
		return history_id;
	}

	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}

	@Column(name = "history_time", unique = false, nullable = true)
	public String getHistory_time() {
		return history_time;
	}

	public void setHistory_time(String history_time) {
		this.history_time = history_time;
	}

	@Column(name = "history_kind", unique = false, nullable = true)
	public String getHistory_kind() {
		return history_kind;
	}

	public void setHistory_kind(String history_kind) {
		this.history_kind = history_kind;
	}

	@Column(name = "history_key", unique = false, nullable = true)
	public String getHistory_key() {
		return history_key;
	}

	public void setHistory_key(String history_key) {
		this.history_key = history_key;
	}

	@Column(name = "history_user_id")
	public Integer getHistory_user_id() {
		return history_user_id;
	}

	public void setHistory_user_id(Integer history_user_id) {
		this.history_user_id = history_user_id;
	}

	@Override
	public String toString() {
		return "history_id" + history_id + "history_time" + history_time + "history_kind" + history_kind + "history_key"
				+ history_key;
	}
}
