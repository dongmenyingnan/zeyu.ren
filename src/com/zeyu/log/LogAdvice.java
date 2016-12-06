package com.zeyu.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.zeyu.util.Log4jUtil;

@Aspect
public class LogAdvice {

	/**
	 * 在方法开始前纪录
	 * 
	 * @param jp
	 */
	@Before("com.zeyu.log.LogPointcut.inServiceLayer()")
	public void serviceLogInfo(JoinPoint jp) {
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		Log4jUtil.getBusinessLogger().info(className+":"+methodName+"开始");
		/*System.out.println("=====================================");
		System.out.println("====位于：" + className);
		System.out.println("====调用" + methodName + "方法-开始！");
		Object[] args = jp.getArgs(); // 获得参数列表
		if (args.length <= 0) {
			System.out.println("====" + methodName + "方法没有参数");
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println("====参数  " + (i + 1) + "：" + args[i]);
			}
		}
		System.out.println("=====================================");*/
	}

	/**
	 * 在方法结束后纪录
	 * 
	 * @param jp
	 */
	@After("com.zeyu.log.LogPointcut.inServiceLayer()")
	public void serviceLogInfoAfter(JoinPoint jp) {
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		Log4jUtil.getBusinessLogger().info(className+":"+methodName+"结束");
	}
	@Before("com.zeyu.log.LogPointcut.inDaoLayer()")
	public void daoLogInfo(JoinPoint jp){
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		Log4jUtil.getSQLLogger().info(className+":"+methodName+"开始");
	}
	
	@After("com.zeyu.log.LogPointcut.inDaoLayer()")
	public void daoLogInfoAfter(JoinPoint jp){
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		Log4jUtil.getSQLLogger().info(className+":"+methodName+"结束");
	}

}
