package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.BugDao;
import com.zeyu.entity.Bug;
import com.zeyu.service.BugService;

@Service("bugService")
public class BugServiceImpl implements BugService {
	@Resource
	BugDao bugDao;
	
	@Override
	public List<Bug> searchBug(String str) {
		return bugDao.findBySearch("bug_label='"+str+"'");
	}
	@Override
	public List<Bug> searchAbnormal(String str) {
		return bugDao.findBySearch(str);
	}

	@Override
	public Bug getLabelContent(String label,int kind) {
		return bugDao.findByProperty("model.bug_label='"+label+"'"+"and "+"model.bug_kind="+kind).get(0);
	}
	@Override
	public List<Bug> getLabelsByKind(int kind) {
		return bugDao.findByProperty("model.bug_kind="+kind);
	}


}
