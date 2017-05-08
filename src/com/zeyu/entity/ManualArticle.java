package com.zeyu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_manualartcle", catalog = "zeyu")
public class ManualArticle {
	
	private Integer manualartcle_id;
	
    private Integer uuid;
    @Column(name = "uuid", nullable = true)
	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}



	private String  manualartcle_title;
	
	private String manualartcle_content;

	private String maualartcle_author;
	
	private Date maualartcle_time;
	
	private String manualartcle_type;

	private String create_time;
	
	
	@Column(name = "create_time", nullable = true)
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manualartcle_id", unique = true, nullable = true)
	public Integer getManualartcle_id() {
		return manualartcle_id;
	}

	public void setManualartcle_id(Integer manualartcle_id) {
		this.manualartcle_id = manualartcle_id;
	}
	@Column(name = "manualartcle_title", nullable = true)
	public String getManualartcle_title() {
		return manualartcle_title;
	}

	public void setManualartcle_title(String manualartcle_title) {
		this.manualartcle_title = manualartcle_title;
	}
	@Column(name = "manualartcle_content", nullable = true)
	public String getManualartcle_content() {
		return manualartcle_content;
	}

	public void setManualartcle_content(String manualartcle_content) {
		this.manualartcle_content = manualartcle_content;
	}
	@Column(name = "maualartcle_author", nullable = true)
	public String getMaualartcle_author() {
		return maualartcle_author;
	}

	public void setMaualartcle_author(String maualartcle_author) {
		this.maualartcle_author = maualartcle_author;
	}
	@Column(name = "maualartcle_time", nullable = true)
	public Date getMaualartcle_time() {
		return maualartcle_time;
	}

	public void setMaualartcle_time(Date maualartcle_time) {
		this.maualartcle_time = maualartcle_time;
	}
	@Column(name = "manualartcle_type", nullable = true)
	public String getManualartcle_type() {
		return manualartcle_type;
	}

	public void setManualartcle_type(String manualartcle_type) {
		this.manualartcle_type = manualartcle_type;
	}
	
	
	
	@Override
	public String toString() {
		return "ManualArticle [manualartcle_id=" + manualartcle_id + ", manualartcle_title=" + manualartcle_title
				+ ", manualartcle_content=" + manualartcle_content + ", maualartcle_author=" + maualartcle_author
				+ ", maualartcle_time=" + maualartcle_time + ", manualartcle_type=" + manualartcle_type
				+ ", create_time=" + create_time + "]";
	}
	
	
	

}
