package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.CollectionDao;
import com.zeyu.entity.Collection;

@Repository("collectionDao")
public class CollectionDaoImpl extends BaseDaoImpl<Collection> implements CollectionDao{

	public CollectionDaoImpl(Class<Collection> cls) {
		super(cls);
	}
	public CollectionDaoImpl() {
		super(Collection.class);
	}

}
