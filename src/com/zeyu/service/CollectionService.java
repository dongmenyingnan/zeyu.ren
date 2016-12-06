package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Collection;

public interface CollectionService {
	public boolean add(Collection collection);
	public boolean isAttention(int user_id,int question_id);
	
	public boolean isAttentionArticle(int user_id,int article_id);
	public List<Collection> getMyCollection(int coll_user_id, int coll_kind);
}
