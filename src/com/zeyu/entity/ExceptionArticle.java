package com.zeyu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_exceptionartcle", catalog = "zeyu")
public class ExceptionArticle {
	
	private Integer exceptionarticle_id;
	
	private String  exceptionarticle_title;
	
	private String exceptionarticle_content;

	private String exceptionarticle_author;
	
	private Date exceptionarticle_time;
	
	private String exceptionarticle_type;

	private String create_time;
	
	 private Integer uuid;
	    @Column(name = "uuid", nullable = true)
		public Integer getUuid() {
			return uuid;
		}

		public void setUuid(Integer uuid) {
			this.uuid = uuid;
		}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exceptionarticle_id", unique = true, nullable = true)
	public Integer getExceptionarticle_id() {
		return exceptionarticle_id;
	}

	public void setExceptionarticle_id(Integer exceptionarticle_id) {
		this.exceptionarticle_id = exceptionarticle_id;
	}
	@Column(name = "exceptionarticle_title", nullable = true)
	public String getExceptionarticle_title() {
		return exceptionarticle_title;
	}

	public void setExceptionarticle_title(String exceptionarticle_title) {
		this.exceptionarticle_title = exceptionarticle_title;
	}
	@Column(name = "exceptionarticle_content", nullable = true)
	public String getExceptionarticle_content() {
		return exceptionarticle_content;
	}

	public void setExceptionarticle_content(String exceptionarticle_content) {
		this.exceptionarticle_content = exceptionarticle_content;
	}
	@Column(name = "exceptionarticle_author", nullable = true)
	public String getExceptionarticle_author() {
		return exceptionarticle_author;
	}

	public void setExceptionarticle_author(String exceptionarticle_author) {
		this.exceptionarticle_author = exceptionarticle_author;
	}
	@Column(name = "exceptionarticle_time", nullable = true)
	public Date getExceptionarticle_time() {
		return exceptionarticle_time;
	}

	public void setExceptionarticle_time(Date exceptionarticle_time) {
		this.exceptionarticle_time = exceptionarticle_time;
	}
	@Column(name = "exceptionarticle_type", nullable = true)
	public String getExceptionarticle_type() {
		return exceptionarticle_type;
	}

	public void setExceptionarticle_type(String exceptionarticle_type) {
		this.exceptionarticle_type = exceptionarticle_type;
	}
	@Column(name = "create_time", nullable = true)
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	
	@Override
	public String toString() {
		return "ExceptionArticle [exceptionarticle_id=" + exceptionarticle_id + ", exceptionarticle_title="
				+ exceptionarticle_title + ", exceptionarticle_content=" + exceptionarticle_content
				+ ", exceptionarticle_author=" + exceptionarticle_author + ", exceptionarticle_time="
				+ exceptionarticle_time + ", exceptionarticle_type=" + exceptionarticle_type + ", create_time="
				+ create_time + "]";
	}
	
	
	
	

}
