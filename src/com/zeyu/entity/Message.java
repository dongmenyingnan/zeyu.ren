package com.zeyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//快速手册
@Entity
@Table(name = "t_message", catalog = "zeyu")
public class Message implements Serializable{

	private static final long serialVersionUID = 3289016315352057759L;
	private Integer msg_id;
	private String msg_title;
	private String msg_content;
	private Integer msg_kind;
	
	@Id
	@GeneratedValue
	@Column(name = "msg_id", unique = true, nullable = true)
	public Integer getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(Integer msg_id) {
		this.msg_id = msg_id;
	}

	@Column(name = "msg_title",  nullable = true)
	public String getMsg_title() {
		return msg_title;
	}

	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}
	
	@Column(name = "msg_content",  nullable = true)
	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	@Column(name = "msg_kind",  nullable = true)
	public Integer getMsg_kind() {
		return msg_kind;
	}

	public void setMsg_kind(Integer msg_kind) {
		this.msg_kind = msg_kind;
	}
	
	@Override
	public String toString() {
		return "msg_id"+msg_id+"msg_title"+msg_title+"msg_content"+msg_content+"msg_kind"+msg_kind;
	}

}
