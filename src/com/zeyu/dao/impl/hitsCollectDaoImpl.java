package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;


import com.zeyu.dao.hitsCollectDao;
import com.zeyu.entity.hitsCollect;

@Repository("hitsCollectDao")
public class hitsCollectDaoImpl extends BaseDaoImpl<hitsCollect> implements hitsCollectDao {
	public hitsCollectDaoImpl(){
		super(hitsCollect.class);
	}

	
}
