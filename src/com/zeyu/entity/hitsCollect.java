package com.zeyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_hisCollect", catalog = "zeyu")
public class hitsCollect {
	private Integer coll_id;
	private Integer coll_user_id;
	private Integer coll_ques_id;
	private Integer coll_arts_id;
	

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
	@Column(name = "coll_ques_id", nullable = true)
	public Integer getColl_ques_id() {
		return coll_ques_id;
	}

	public void setColl_ques_id(Integer coll_ques_id) {
		this.coll_ques_id = coll_ques_id;
	}
	@Column(name = "coll_arts_id", nullable = true)
	public Integer getColl_arts_id() {
		return coll_arts_id;
	}

	public void setColl_arts_id(Integer coll_arts_id) {
		this.coll_arts_id = coll_arts_id;
	}


}
