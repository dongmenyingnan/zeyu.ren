package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.HistoryDao;
import com.zeyu.entity.History;
import com.zeyu.service.HistoryService;

@Service("historyService")
public class HistoryServiceimpl implements HistoryService{

	@Resource
	HistoryDao historyDao;
	
	@Override
	public boolean saveSearch(History entity) {
		historyDao.add(entity);
		return true;
	}

	@Override
	public List<History> querySearch(String str) {
		return historyDao.findBySearch(str);
	}
	
}
