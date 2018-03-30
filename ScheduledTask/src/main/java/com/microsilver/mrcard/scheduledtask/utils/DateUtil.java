package com.microsilver.mrcard.scheduledtask.utils;

import org.joda.time.DateTime;
import org.joda.time.Hours;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static long getNowDate() {
		return System.currentTimeMillis() / 1000;
	}

	// 数据库的秒值转换为日期
	public static Date secondToDate(Integer second) {
		return new Date((long) second.intValue() * 1000);
	}

	// 将日期转为数据库的秒
	public static Integer dateToSecond(Date expireTime) {
		return (int) (expireTime.getTime() / 1000);
	}

	/**
	 * 添加分钟
	 * 
	 * @return
	 */
	public static Date addMinutes(Date date, Integer minutes) {
		return new Date(date.getTime() + minutes * 60 * 1000);
	}

	/**
	 * 添加天数
	 * 
	 * @return
	 */
	public static Date addDays(Date date, Integer days) {
		return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
	}

	public static String dateToString(Date date) {
		return format.format(date);
	}
	
	/**
	 * 已当前时间为基准获取某天某小时的秒值 for example hour = 5,add = -2 表示获取前天5点整时刻的秒值
	 * @param hour
	 * @param add
	 * @return
	 */
	public static Integer getTime(int hour,int add){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,add);
		cal.set(Calendar.HOUR_OF_DAY,hour);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		return (int)(cal.getTimeInMillis()/1000);
	}

	public static int daysBetween(long d1,long d2){
		//joda-time
		DateTime start=new DateTime(d1);
		DateTime end=new DateTime(d2);
		int result = Hours.hoursBetween(start,end).getHours();
		return result;
	}
}
