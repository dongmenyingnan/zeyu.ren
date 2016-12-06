package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.BugDao;
import com.zeyu.dao.CollectionDao;
import com.zeyu.entity.Bug;
import com.zeyu.entity.Collection;
import com.zeyu.service.BugService;
import com.zeyu.service.CollectionService;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {
	@Resource
	CollectionDao collectionDao;

	@Override
	public boolean add(Collection collection) {
		collectionDao.add(collection);
		return true;
	}

	@Override
	public List<Collection> getMyCollection(int coll_user_id,int coll_kind) {
		return collectionDao.findByProperty("model.coll_kind="+coll_kind+"and model.coll_user_id="+coll_user_id);
	}
	@Override
	public boolean isAttention(int user_id, int question_id) {
		List<Collection> lists=collectionDao.findByProperty("coll_user_id="+user_id+"and "+"coll_ques_id="+question_id);
		if(lists!=null&&lists.size()>=1)
			return true;
		return false;
	}

	@Override
	public boolean isAttentionArticle(int user_id, int article_id) {
		List<Collection> lists=collectionDao.findByProperty("coll_user_id="+user_id+"and "+"coll_art_id="+article_id);
		if(lists!=null&&lists.size()>=1)
			return true;
		return false;
	}

}
