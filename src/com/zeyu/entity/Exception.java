package com.zeyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_exception", catalog = "zeyu")
public class Exception {
private static final long serialVersionUID = -166566598099192428L;
	
	private Integer exception_id ;
	
	private String  exception_name;
	
	private Integer  exception_type;
	
	private String exception_url;
	
	private String exception_backgroundimg;
	
	private String exception_lab;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exception_id", unique = true, nullable = true)
	public Integer getException_id() {
		return exception_id;
	}

	public void setException_id(Integer exception_id) {
		this.exception_id = exception_id;
	}
	@Column(name = "exception_name", nullable = true, length = 255)
	public String getException_name() {
		return exception_name;
	}

	public void setException_name(String exception_name) {
		this.exception_name = exception_name;
	}
	@Column(name = "exception_type", nullable = true)
	public Integer getException_type() {
		return exception_type;
	}

	public void setException_type(Integer exception_type) {
		this.exception_type = exception_type;
	}
	@Column(name = "exception_url", nullable = true, length = 50)
	public String getException_url() {
		return exception_url;
	}

	public void setException_url(String exception_url) {
		this.exception_url = exception_url;
	}
	@Column(name = "exception_backgroundimg", nullable = true, length = 50)
	public String getException_backgroundimg() {
		return exception_backgroundimg;
	}

	public void setException_backgroundimg(String exception_backgroundimg) {
		this.exception_backgroundimg = exception_backgroundimg;
	}
	@Column(name = "exception_lab", nullable = true, length = 255)
	public String getException_lab() {
		return exception_lab;
	}

	public void setException_lab(String exception_lab) {
		this.exception_lab = exception_lab;
	}
	
	
}
