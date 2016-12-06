package com.zeyu.util;

import org.springframework.stereotype.Component;

@Component("config")
public class Config {
	public static String company = "";
	public static String webname = "";
	public static long hour24 = 86400000L;
	public static long hour48 = 172800000L;
	public static int items = 50;
	public static String site = "";
	public static String smtp = "smtp.exmail.qq.com";
	public static String from = "admin@wutuobang.cc";
	public static String username = "admin@wutuobang.cc";
	public static String password = "zhanghm123";
	public static long acceptRepair = 86400000L;
	public static long endRepair = 86400000L;
	public static long checkRepair = 86400000L;
	public static long acceptClear = 86400000L;
	public static long endClear = 86400000L;
	public static long checkClear = 86400000L;

	// @Resource
	// private CompanyDao infoDao;

	// @Resource
	// private TimeoutDAO timeoutDao;
	//
	// public void init(Integer rgnid) {
	// Timeout timeout = this.timeoutDao.findById(rgnid);
	// if (timeout != null) {
	// acceptRepair = timeout.acceptRepair.longValue();
	// endRepair = timeout.endRepair.longValue();
	// checkRepair = timeout.checkRepair.longValue();
	// acceptClear = timeout.acceptClear.longValue();
	// endClear = timeout.endClear.longValue();
	// checkClear = timeout.checkClear.longValue();
	// }
	// Info info = this.infoDao.findById(Integer.valueOf(1));
	// site = info.getAddress();
	// items = info.getPageitems().intValue();
	// company = info.getSyscompany();
	// webname = info.getSysname();
	// }
}