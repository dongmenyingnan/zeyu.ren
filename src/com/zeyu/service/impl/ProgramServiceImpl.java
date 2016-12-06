package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ProgramDao;
import com.zeyu.entity.Program;
import com.zeyu.service.ProgramService;

@Service("programService")
public class ProgramServiceImpl implements ProgramService{
	@Resource
	ProgramDao programDao;
	@Override
	public List<Program> excellentProgramShow() {
		return programDao.findAll();
	}

	@Override
	public List<Program> excellentProgramShowHot() {
		return programDao.findAll();
	}

	@Override
	public List<Program> excellentProgramSearch(String str) {
		return programDao.findBySearch(str);
	}
}
