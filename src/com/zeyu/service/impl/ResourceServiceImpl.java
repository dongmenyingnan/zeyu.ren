package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ResourceDao;
import com.zeyu.entity.Message;
import com.zeyu.entity.Program;
import com.zeyu.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{

	@Resource
	ResourceDao resourceDao;
	@Override
	public List<Message> showCommon() {
		return resourceDao.findAll();
	}

	@Override
	public Message fastSearch() {
		int randomCount;
		int count=resourceDao.findCount();
		randomCount=(int) Math.round(Math.random()*count);
		return resourceDao.findById(randomCount);
	}

	@Override
	public List<Message> search(String str) {
		return resourceDao.findByProperty("model.msg_title like '%"+str+"%'");
	}

	
}
