package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ProgramDao;
import com.zeyu.entity.Program;

@Repository("programDao")
public class ProgramDaoImpl extends BaseDaoImpl<Program> implements ProgramDao{
	public ProgramDaoImpl() {
		super(Program.class);
	}
}
