package com.microsilver.mrcard.common;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Name com.microsilver.mrcard.common.Utils
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年8月10日 下午2:11:33
 * @Copyright Micro Silver
 *
 */
public class Utils {
	public static int getCurrentTime() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	/**
	 * 获取http请求IP
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
	public static String format(int num) {
		String str = "";
		if (num < 10) {
			str = "0" + num;
		} else {
			str += num;
		}
		return str;
	}
	public static String createOrderSn(String prefix) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		sb.append(prefix).append(format(year)).append(format(month)).append(format(day)).append(format(hour))
				.append(format(min)).append(format(sec))
				.append(String.valueOf((int) (Math.random() * 900000 + 100000)));
		return sb.toString();
	}
}
