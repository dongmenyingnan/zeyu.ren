package com.zeyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_collection", catalog = "zeyu")
public class Collection {
	

	private Integer coll_id;
	private Integer coll_user_id;
	private Integer coll_ques_id;
	private Integer coll_kind;// 1表示 收藏 2表示关注
	private Integer coll_con_kind;// 1表示 收藏问题 2表示收藏方案
	private Integer coll_art_id;
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coll_id", unique = true, nullable = true)
	public Integer getColl_id() {
		return coll_id;
	}

	public void setColl_id(Integer coll_id) {
		this.coll_id = coll_id;
	}

	@Column(name = "coll_user_id", nullable = true)
	public Integer getColl_user_id() {
		return coll_user_id;
	}

	public void setColl_user_id(Integer coll_user_id) {
		this.coll_user_id = coll_user_id;
	}

	@Column(name = "coll_art_id", nullable = true)
	public Integer getColl_art_id() {
		return coll_art_id;
	}

	public void setColl_art_id(Integer coll_art_id) {
		this.coll_art_id = coll_art_id;
	}
	
	@Column(name = "coll_ques_id", nullable = true)
	public Integer getColl_ques_id() {
		return coll_ques_id;
	}

	public void setColl_ques_id(Integer coll_ques_id) {
		this.coll_ques_id = coll_ques_id;
	}

	@Column(name = "coll_kind", nullable = true)
	public Integer getColl_kind() {
		return coll_kind;
	}

	public void setColl_kind(Integer coll_kind) {
		this.coll_kind = coll_kind;
	}

	@Column(name = "coll_con_kind", nullable = true)
	public Integer getColl_con_kind() {
		return coll_con_kind;
	}

	public void setColl_con_kind(Integer coll_con_kind) {
		this.coll_con_kind = coll_con_kind;
	}
	@Override
	public String toString() {
		return "Collection [coll_id=" + coll_id + ", coll_user_id=" + coll_user_id + ", coll_ques_id=" + coll_ques_id
				+ ", coll_kind=" + coll_kind + ", coll_con_kind=" + coll_con_kind + ", coll_art_id=" + coll_art_id
				+ "]";
	}
}
