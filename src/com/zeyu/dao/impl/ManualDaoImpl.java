package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ManualDao;
import com.zeyu.entity.Manual;

@Repository("manualDao")
public class ManualDaoImpl extends BaseDaoImpl<Manual> implements ManualDao{
	public ManualDaoImpl(){
		super(Manual.class);
	}

}
