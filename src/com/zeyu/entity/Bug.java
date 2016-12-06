package com.zeyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bug", catalog = "zeyu")
public class Bug implements Serializable{
	
	private static final long serialVersionUID = -3207266144508552878L;
	private Integer bug_id;
	private String bug_label;
	private String bug_content;
	private Integer bug_kind;//1是bug    2是异常

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bug_id", unique = true, nullable = true)
	public Integer getBug_id() {
		return bug_id;
	}

	public void setBug_id(Integer bug_id) {
		this.bug_id = bug_id;
	}

	@Column(name = "bug_label")
	public String getBug_label() {
		return bug_label;
	}

	public void setBug_label(String bug_label) {
		this.bug_label = bug_label;
	}

	@Column(name = "bug_content")
	public String getBug_content() {
		return bug_content;
	}

	public void setBug_content(String bug_content) {
		this.bug_content = bug_content;
	}

	@Column(name = "bug_kind")
	public Integer getBug_kind() {
		return bug_kind;
	}

	public void setBug_kind(Integer bug_kind) {
		this.bug_kind = bug_kind;
	}

}
