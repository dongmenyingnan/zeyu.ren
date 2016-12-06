package com.zeyu.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program", catalog = "zeyu")
public class Program implements Serializable {

	private static final long serialVersionUID = 7908869812286483484L;
	private Integer program_id;
	private Integer program_click_time;
	private Integer program_user_id;
	private Integer program_kind;

	private String program_title;
	private String program_img;
	private String program_general;
	private String program_content;
	private String program_author;
	private Date program_create_time;

	@Id
	@GeneratedValue
	@Column(name = "program_id", unique = true, nullable = true)
	public Integer getProgram_id() {
		return program_id;
	}

	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
	}

	@Column(name = "program_click_time", unique = false, nullable = true)
	public Integer getProgram_click_time() {
		return program_click_time;
	}

	public void setProgram_click_time(Integer program_click_time) {
		this.program_click_time = program_click_time;
	}

	@Column(name = "program_user_id", unique = false, nullable = true)
	public Integer getProgram_user_id() {
		return program_user_id;
	}

	public void setProgram_user_id(Integer program_user_id) {
		this.program_user_id = program_user_id;
	}

	@Column(name = "program_kind", unique = false, nullable = true)
	public Integer getProgram_kind() {
		return program_kind;
	}

	public void setProgram_kind(Integer program_kind) {
		this.program_kind = program_kind;
	}

	@Column(name = "program_title", unique = false, nullable = true)
	public String getProgram_title() {
		return program_title;
	}

	public void setProgram_title(String program_title) {
		this.program_title = program_title;
	}

	@Column(name = "program_img", unique = false, nullable = true)
	public String getProgram_img() {
		return program_img;
	}

	public void setProgram_img(String program_img) {
		this.program_img = program_img;
	}

	@Column(name = "program_general", unique = false, nullable = true)
	public String getProgram_general() {
		return program_general;
	}

	public void setProgram_general(String program_general) {
		this.program_general = program_general;
	}

	@Column(name = "program_content", unique = false, nullable = true)
	public String getProgram_content() {
		return program_content;
	}

	public void setProgram_content(String program_content) {
		this.program_content = program_content;
	}

	@Column(name = "program_author", unique = false, nullable = true)
	public String getProgram_author() {
		return program_author;
	}

	public void setProgram_author(String program_author) {
		this.program_author = program_author;
	}

	@Column(name = "program_create_time", unique = false, nullable = true)
	public Date getProgram_create_time() {
		return program_create_time;
	}

	public void setProgram_create_time(Date program_create_time) {
		this.program_create_time = program_create_time;
	}

	@Override
	public String toString() {
		return "program_id" + program_id + "program_title" + program_title + "program_general" + program_general
				+ "program_content" + program_content;
	}

}
