package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.BugDao;
import com.zeyu.entity.Bug;

@Repository("bugDao")
public class BugDaoImpl extends BaseDaoImpl<Bug> implements BugDao{

	public BugDaoImpl(Class<Bug> cls) {
		super(cls);
	}
	public BugDaoImpl() {
		super(Bug.class);
	}
	
}
