package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.ExceptionArticle;
import com.zeyu.entity.Manual;
import com.zeyu.entity.ManualArticle;
import com.zeyu.entity.Exception;
public interface ExceptionArticleService {
	
	List<Exception> getcateSeach(int flag, int page);
	
	ExceptionArticle findByIdArtcle(int exception_id);
	
	String ExceptionArticle_time(int timer);

	boolean delete(String id);

	void adddata(ExceptionArticle exceptionArticle);

	void add(Exception exception);


	int getExceptionCountByUserId(int i);
	
}
