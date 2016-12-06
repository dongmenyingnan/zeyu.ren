package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Message;
import com.zeyu.entity.Program;

public interface ResourceService {
	//快速手册
	public List<Message> showCommon();
	public Message fastSearch();
	public List<Message> search(String str);
	
	//常见异常
	
	//常见错误
	
}
