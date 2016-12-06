package com.zeyu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeyu.entity.Message;
import com.zeyu.entity.Program;
import com.zeyu.service.ProgramService;
import com.zeyu.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ProgramAction extends BaseAction {

	@Autowired
	ProgramService programService;

	// 优秀方案
	// 优秀方案列表显示
	@RequestMapping(value = "/excellentProgramShow.action", method = RequestMethod.GET)
	public String excellentProgramShow(Model model) {
		List<Program> hotPrograms = programService.excellentProgramShowHot();
		model.addAttribute("hotPrograms", hotPrograms);
		List<Program> programs = programService.excellentProgramShow();
		model.addAttribute("programs", programs);
		return "excellentProgram";
	}

	// 优秀方案 热门显示
	@RequestMapping(value = "/excellentProgramShowHot.action", method = RequestMethod.GET)
	public String excellentProgramShowHot(Model model) {
		List<Program> hotPrograms = programService.excellentProgramShowHot();
		model.addAttribute("hotPrograms", hotPrograms);
		return "excellentProgram";
	}

	// 优秀方案 搜索
	@RequestMapping(value = "/excellentProgramSearch.action", method = RequestMethod.POST)
	public String excellentProgramSearch(Model model, String searchContent) {
		// 将搜索 记录到搜索数据库中
		Date history_time = new Date();
		saveSearch(history_time, "优秀方案", searchContent);

		List<Program> programs = programService.excellentProgramSearch("program_general='" + searchContent + "'");
		model.addAttribute("programs", programs);
		List<Program> hotPrograms = programService.excellentProgramShowHot();
		model.addAttribute("hotPrograms", hotPrograms);
		return "excellentProgram";
	}

}
