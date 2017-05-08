package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.ExceptionDao;
import com.zeyu.entity.Exception;
@Repository("exceptionDao")
public class ExceptionDaoImpl extends BaseDaoImpl<Exception> implements ExceptionDao{
	public ExceptionDaoImpl(){
		super(Exception.class);
	}
}
