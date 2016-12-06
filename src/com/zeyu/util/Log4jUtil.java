package com.zeyu.util;

import org.apache.log4j.Logger;

public class Log4jUtil {

	public static Logger getSQLLogger() {
		return Logger.getLogger("sql");
	}

	public static Logger getBusinessLogger() {
		return Logger.getLogger("business");
	}

	public static Logger getSimpleErrorLogger() {
		return Logger.getLogger("simpleError");
	}

	public static Logger getNormalErrorLogger() {
		return Logger.getLogger("normalError");
	}
}
