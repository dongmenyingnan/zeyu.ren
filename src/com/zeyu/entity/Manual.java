package com.zeyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_manual", catalog = "zeyu")
public class Manual {
	
	
	private static final long serialVersionUID = -166566598099192428L;
	
	private Integer manual_id ;
	
	private String  manual_name;
	
	private Integer  manual_type;
	
	private String manual_url;
	
	private String manual_backgroundimg;
	
	private String manual_lab;
	@Column(name = "manual_lab", nullable = true, length = 255)
	public String getManual_lab() {
		return manual_lab;
	}

	public void setManual_lab(String manual_lab) {
		this.manual_lab = manual_lab;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manual_id", unique = true, nullable = true)
	public Integer getManual_id() {
		return manual_id;
	}

	public void setManual_id(Integer manual_id) {
		this.manual_id = manual_id;
	}
	@Column(name = "manual_name", nullable = true, length = 50)
	public String getManual_name() {
		return manual_name;
	}

	public void setManual_name(String manual_name) {
		this.manual_name = manual_name;
	}
	@Column(name = "manual_type", nullable = true)
	public Integer getManual_type() {
		return manual_type;
	}

	public void setManual_type(Integer manual_type) {
		this.manual_type = manual_type;
	}
	@Column(name = "manual_url", nullable = true, length = 50)
	public String getManual_url() {
		return manual_url;
	}

	public void setManual_url(String manual_url) {
		this.manual_url = manual_url;
	}
	@Column(name = "manual_backgroundimg", nullable = true, length = 50)
	public String getManual_backgroundimg() {
		return manual_backgroundimg;
	}

	public void setManual_backgroundimg(String manual_backgroundimg) {
		this.manual_backgroundimg = manual_backgroundimg;
	}

	@Override
	public String toString() {
		return "Manual [manual_id=" + manual_id + ", manual_name=" + manual_name + ", manual_type=" + manual_type
				+ ", manual_url=" + manual_url + ", manual_backgroundimg=" + manual_backgroundimg + "]";
	}
	
	
	
	

}
