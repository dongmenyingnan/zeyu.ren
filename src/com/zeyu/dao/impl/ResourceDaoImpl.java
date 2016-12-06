package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ResourceDao;
import com.zeyu.entity.Message;


@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Message> implements ResourceDao{

	public ResourceDaoImpl() {
		super(Message.class);
	}

}
