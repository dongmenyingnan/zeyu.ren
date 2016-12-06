package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.HistoryDao;
import com.zeyu.entity.History;

@Repository("historyDao")
public class HistoryDaoImpl extends BaseDaoImpl<History> implements HistoryDao {

	public HistoryDaoImpl() {
		super(History.class);
	}

}
