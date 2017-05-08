package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Manual;
import com.zeyu.entity.ManualArticle;
import com.zeyu.entity.vo.QuestionVo;

public interface ManualService {

	List<Manual> getcateSeach(int flag, int page);
	
	int getManualCountByUserId(int id);
	
	ManualArticle findByIdArtcle(int manual_id);
	
	String ManualArticle_time(int timer);

	public boolean delete(String id);

	void add(Manual manual);
	
	void adddata(ManualArticle manualArticle);

	void updata(ManualArticle manualArticle);

	
}
