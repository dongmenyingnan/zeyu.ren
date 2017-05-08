package com.zeyu.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user",catalog="zeyu")
public class User implements Serializable {
	
	private static final long serialVersionUID = 6936120896390866161L;
	private Integer user_id;
	private String user_name;
	private String user_tele;
	private String user_email;
	private String user_pass;
	private String user_sex;
	private String user_per_web;
	private String user_cha_web;
	private Date user_birth;
	private String user_city;
	private String user_address;
	private String user_intro;
	private Integer user_kind;
	private String user_type;
	private String user_token;
	private String user_token_status;
	
	@Column(name = "user_token_status", unique = true, nullable = true)
	public String getUser_token_status() {
		return user_token_status;
	}

	public void setUser_token_status(String user_token_status) {
		this.user_token_status = user_token_status;
	}

	@Column(name = "user_token", unique = true, nullable = true)
	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = true)
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Column(name = "user_name", unique = true, nullable = true)
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Column(name = "user_email", unique = true, nullable = true)
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Column(name = "user_pass", unique = false, nullable = false)
	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	
	
	@Column(name = "user_sex", unique = false, nullable = true)
	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	@Column(name = "user_per_web", unique = false, nullable = true)
	public String getUser_per_web() {
		return user_per_web;
	}

	public void setUser_per_web(String user_per_web) {
		this.user_per_web = user_per_web;
	}
	@Column(name = "user_cha_web", unique = false, nullable = true)
	public String getUser_cha_web() {
		return user_cha_web;
	}

	public void setUser_cha_web(String user_cha_web) {
		this.user_cha_web = user_cha_web;
	}

	@Column(name = "user_birth", unique = false, nullable = true)
	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}

	@Column(name = "user_city", unique = false, nullable = true)
	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	@Column(name = "user_address", unique = false, nullable = true)
	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Column(name = "user_intro", unique = false, nullable = true)
	public String getUser_intro() {
		return user_intro;
	}

	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}
	
	@Column(name = "user_kind",columnDefinition="int default 1",nullable = true)
	public Integer getUser_kind() {
		return user_kind;
	}
	public void setUser_kind(Integer user_kind) {
		this.user_kind = user_kind;
	}

	@Column(name="user_type",columnDefinition="varchar(45) default '学生'",nullable = true)
	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Column(name="user_tele", unique = true)
	public String getUser_tele() {
		return user_tele;
	}

	public void setUser_tele(String user_tele) {
		this.user_tele = user_tele;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_tele=" + user_tele + ", user_email="
				+ user_email + ", user_pass=" + user_pass + ", user_sex=" + user_sex + ", user_per_web=" + user_per_web
				+ ", user_cha_web=" + user_cha_web + ", user_birth=" + user_birth + ", user_city=" + user_city
				+ ", user_address=" + user_address + ", user_intro=" + user_intro + ", user_kind=" + user_kind
				+ ", user_type=" + user_type + ", user_token=" + user_token + ", user_token_status=" + user_token_status
				+ "]";
	}

	
	
}
