package com.zeyu.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogPointcut {

	@Pointcut("execution(* com.zeyu.service..*.*(..))")
	public void inServiceLayer() {
	}
	
	@Pointcut("execution(* com.zeyu.dao..*.*(..))")
	public void inDaoLayer(){
	}
	
	@Pointcut("execution(* com.zeyu.controller..*.*(..))")
	public void inControllerLayer(){}

}
