package com.zeyu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.zeyu.entity.History;
import com.zeyu.service.HistoryService;

@Controller
public class BaseAction {
	
	@Autowired
	HistoryService historyService;
	
	protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void saveSearch(Date history_time,String history_kind,String history_key){
		History history=new History();
		history.setHistory_time(format.format(history_time));
		history.setHistory_kind(history_kind);
		history.setHistory_key(history_key);
		historyService.saveSearch(history);
	}
	
	

	public void printJSON(HttpServletResponse response, Object obj) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "application/json");
		try {
			PrintWriter out = response.getWriter();
			out.print(JSON.toJSONString(obj));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void out(HttpServletResponse response, String content) {
		try {
			response.setHeader("Content-type", "application/json");
			PrintWriter out = response.getWriter();
			out.print(content);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
