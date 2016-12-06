package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Program;

public interface ProgramService {
	// 优秀方案
	public List<Program> excellentProgramShow();

	public List<Program> excellentProgramShowHot();

	public List<Program> excellentProgramSearch(String str);
}
