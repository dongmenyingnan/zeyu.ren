package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.FeedBackDao;
import com.zeyu.entity.FeedBack;

@Repository("feedBackDao")
public class FeedBackDaoImpl extends BaseDaoImpl<FeedBack> implements FeedBackDao {

	public FeedBackDaoImpl() {
		super(FeedBack.class);
	}

}
