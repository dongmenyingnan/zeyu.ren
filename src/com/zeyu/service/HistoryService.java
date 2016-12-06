package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.History;

public interface HistoryService {
	public boolean saveSearch(History entity);
	public List<History> querySearch(String str);
}
