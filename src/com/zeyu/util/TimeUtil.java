package com.zeyu.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("timeUtil")
public class TimeUtil {
	/**
	 * 
	 * @param 要转换的毫秒数
	 * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
	 * @author fy.zhang
	 */
	public static String formatDuring(long mss) {
		long days = mss / (1000 * 60 * 60 * 24);
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		return days + " 天 " + hours + " 小时 " + minutes + " 分 " + seconds + " 秒 ";
	}

	/**
	 * @param begin
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return long类型的分钟数
	 */
	public static long translateMinutes(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / (1000 * 60);
	}

	/**
	 * @param begin
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return long类型的小时数
	 */
	public static long translateHours(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / (1000 * 60 * 60);
	}

	/**
	 * @param begin
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return long类型的天数
	 */
	public static long translateDays(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24);
	}

	/**
	 * @param begin
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return long 类型的月数
	 */
	public static long translateMonths(Date begin, Date end) {
		return (end.getYear() - begin.getYear()) * 12 + (end.getMonth() - begin.getMonth()) + (end.getDay()
				- begin.getDay() > 0 ? 0 : -1);
	}

	/**
	 * @param begin
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return long类型的年数
	 */
	public static long translateYears(Date begin, Date end) {
		return end.getYear() - begin.getYear() + (end.getMonth() - begin.getMonth() > 0 ? 0 : -1);
	}

	/**
	 * 
	 * @param begin
	 *            时间段的开始
	 * @param end
	 *            时间段的结束
	 * @return 输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
	 * @author fy.zhang
	 */
	public static String formatDuring(Date begin, Date end) {
		return formatDuring(end.getTime() - begin.getTime());
	}

	public static byte[] getData() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yy MM dd HH mm ss");
		String time = format.format(date);
		byte[] bytes = new byte[6];
		int len = time.split(" ").length;
		for (int i = 0; i < len; i++) {
			byte temp = Byte.parseByte(time.split(" ")[i]);
			bytes[i] = temp;
		}
		return bytes;
	}

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.getMonth());
	}
}
