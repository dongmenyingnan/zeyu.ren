package com.zeyu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeyu.entity.Message;
import com.zeyu.service.HistoryService;
import com.zeyu.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceAction extends BaseAction{
	@Autowired
	ResourceService resourceService;

	// 快速手册显示信息
	@RequestMapping(value = "/fastManualShow.action", method = RequestMethod.GET)
	public String fastManualShowCommon(Model model) {
		List<Message> messages = resourceService.showCommon();
		model.addAttribute("tag", "messages");
		model.addAttribute("messages", messages);
		return "fastManual";
	}

	// 快速手册快速搜索
	@RequestMapping(value = "/fastManualFastSearch.action", method = RequestMethod.GET)
	public String fastManualFastSearch(Model model) {
		Message message = resourceService.fastSearch();
		model.addAttribute("tag", "message");
		model.addAttribute("message", message);
		return "fastManual";
	}

	// 快速手册搜索
	@RequestMapping(value = "/fastManualSearch.action", method = RequestMethod.POST)
	public String fastManualSearch(Model model, String searchContent) {
		//将搜索 记录到搜索数据库中
		Date history_time=new Date();
		saveSearch(history_time, "快速手册", searchContent);
		
		//显示搜索结果列表
		List<Message> messages = resourceService.search(searchContent);
		model.addAttribute("tag", "messages");
		model.addAttribute("messages", messages);
		return "fastManual";
	}

	@RequestMapping(value = "/commonAbnormalShow.action", method = RequestMethod.POST)
	public String commonAbnormalShow(Model model, String searchContent) {
		model.addAttribute("tag", "messages");
		return "commonAbnormal";
	}
	
}
