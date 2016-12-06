package com.zeyu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeyu.entity.Bug;
import com.zeyu.service.BugService;

@Controller
@RequestMapping("/resource")
public class BugAction extends BaseAction {
	@Autowired
	BugService bugService;
	//常见错误  显示label
	@RequestMapping(value="/commonBugGetLabels.action",method=RequestMethod.GET)
	public String commonBugGetLabels(Model model){
		List<Bug> bugs=bugService.getLabelsByKind(1);
		model.addAttribute("bugs",bugs);
		return "commonBug";
	}

	// 常见错误搜索
	@RequestMapping(value = "/commonBugSearch.action", method = RequestMethod.POST)
	public String commonBugSearch(Model model, String searchContent) {
		// 将搜索 记录到搜索数据库中
		Date history_time = new Date();
		saveSearch(history_time, "常见错误", searchContent);
		
		//显示搜索label结果
		List<Bug> bugs=bugService.searchBug(searchContent);
		model.addAttribute("bugs",bugs);
		return "commonBug";
	}
	//常见错误  根据label显示 具体内容
	@RequestMapping(value="commonBugGetLabelContent.action",method=RequestMethod.GET)
	public String commonBugGetLabelContent(Model model,String label){
		List<Bug> bugs=bugService.getLabelsByKind(1);
		model.addAttribute("bugs",bugs);
		Bug bug=bugService.getLabelContent(label,1);
		model.addAttribute("bug", bug);
		return "commonBug";
	}
	
	
	
	
	//常见异常  显示label
		@RequestMapping(value="/commonAbnormalGetLabels.action",method=RequestMethod.GET)
		public String commonAbnormalGetLabels(Model model){
			List<Bug> bugs=bugService.getLabelsByKind(2);
			model.addAttribute("bugs",bugs);
			return "commonAbnormal";
		}

		// 常见异常搜索
		@RequestMapping(value = "/commonAbnormalSearch.action", method = RequestMethod.POST)
		public String commonAbnormalSearch(Model model, String searchContent) {
			// 将搜索 记录到搜索数据库中
			Date history_time = new Date();
			saveSearch(history_time, "常见错误", searchContent);
			
			//显示搜索label结果
			List<Bug> bugs=bugService.searchBug(searchContent);
			model.addAttribute("bugs",bugs);
			return "commonAbnormal";
		}
		//常见异常 根据label显示 具体内容
		@RequestMapping(value="commonAbnormalGetLabelContent.action",method=RequestMethod.GET)
		public String commonAbnormalGetLabelContent(Model model,String label){
			List<Bug> bugs=bugService.getLabelsByKind(2);
			model.addAttribute("bugs",bugs);
			Bug bug=bugService.getLabelContent(label,2);
			model.addAttribute("bug", bug);
			return "commonAbnormal";
		}
	
	
}
