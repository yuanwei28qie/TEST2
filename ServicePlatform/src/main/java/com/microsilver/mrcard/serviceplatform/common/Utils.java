package com.microsilver.mrcard.serviceplatform.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.microsilver.mrcard.common.CryptoTools;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.common.Utils
 * @Description
 * 
 * @Author bruce
 * @Version 2017年7月3日 上午11:27:59
 * @Copyright Micro Silver
 *
 */
public class Utils {
	private final static Logger logger = LoggerFactory.getLogger(Utils.class);

	public static int getCurrentTime() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	public static String getCurrentTime(String reg) throws ParseException {
		String pattern = reg;
		if(!Objects.nonNull(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(System.currentTimeMillis());
	}

	/**
	 * 在某一时间点上加任意分钟数
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static Date addMinutes(Date date,int minutes) {
		long time = date.getTime()+minutes*60*1000;
		return new Date(time);
	}

	/**
	 * 手机注册，拼凑openid
	 * 
	 * @param uniacid
	 * @param mobile
	 * @return
	 */
	public static String getOpenId(int uniacid, String mobile) {
		String openId = String.format("wap_user_%d_%s", uniacid, mobile);
		return openId;
	}

	/**
	 * 获取混合数据数据
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomString(int len) {
		String t = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String n = "";
		for (int r = 0; len > r; ++r) {
			n += t.charAt(new Random().nextInt(t.length()));
		}
		return n;
	}

	public static String createOrderSn() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		sb.append("CD").append(format(year)).append(format(month)).append(format(day)).append(format(hour))
				.append(format(min)).append(format(sec))
				.append(String.valueOf((int) (Math.random() * 900000 + 100000)));
		return sb.toString();
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

	public static String format(int num) {
		String str = "";
		if (num < 10) {
			str = "0" + num;
		} else {
			str += num;
		}
		return str;
	}

	public static int getDayBeginTimestamp() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		Date date2 = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60 * 1000 - gc.get(gc.MINUTE) * 60 * 1000
				- gc.get(gc.SECOND) * 1000);
		return (int) (date2.getTime() / 1000);
	}

	public static void main(String args[]) {
		
		try { 
			System.out.println(getCurrentTime());
			System.out.println(getCurrentTime(null));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 校验APP头信息中的token
	 * 
	 * @param token
	 * @return
	 */
	public static boolean checkToken(String appType,String token,String clientType) {
		boolean result = false;
		String desKey = Consts.APP_TOKEN_DES_KEY;
		try {
			if(appType!=null&&appType.equals("5")){
				//小飞侠骑士版
				desKey = Consts.XIAO_FEI_XIA_DES_KEY;
			}
			String deToken = CryptoTools.decodeByDes(token, desKey);
			int index = deToken.lastIndexOf("+");
			String strCers = deToken.substring(0, index);
			Long times = Long.valueOf(deToken.substring(index + 1));
			Long spaceTime = Math.abs(System.currentTimeMillis() - times);
			//logger.info("token：[{}],终端类型:{},间隔时间:{}", token, clientType,spaceTime);
			if (spaceTime < Consts.TOKEN_EFFECTIVE_SECOND * 1000) {
				String deCers = CryptoTools.decodeByDes(strCers.toString(), desKey);
				String[] strs = deCers.split("[+]");
				if (strs.length >= 3) {
					result = true;
				} else {
					logger.info("证书无效：[{}]", deCers);
				}
			} else {
				logger.info("token已过期：[{}],终端类型:{},间隔时间:{}", token, clientType,spaceTime);
			}
			return result;
		} catch (Exception ex) {
			logger.error("token出错误：[{}],{}", token, ex.getMessage());

		}
		return result;
	}

	/**
	 * 反php序列化
	 * 
	 * @param content
	 *            必须是php序列化后的数组格式
	 * @return
	 */
	public static List<String> unserializePHParray(String content) {
		List<String> list = new ArrayList<String>();
		PHPSerializer p = new PHPSerializer();
		if (StringUtils.isEmpty(content))
			return list;
		try {
			AssocArray array = (AssocArray) p.unserialize(content.getBytes());
			for (int i = 0; i < array.size() + 1; i++) {
				String t = (String) Cast.cast(array.get(i), String.class);
				if (t != null)
					list.add(t);
			}
		} catch (Exception e) {
			System.out.println("反序列化PHParray: " + content + " 失败！！！");
		}
		return list;
	}

	/**
	 * php序列化
	 * 
	 * @param obj
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String phpSerialize(Object obj, String charset) throws UnsupportedEncodingException {
		byte[] serialize = com.microsilver.mrcard.serviceplatform.common.PHPSerializer.serialize(obj, charset);
		return new String(serialize, charset);
	}

	public static Long getTime(int hour, int add) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, add);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	//获取某天的开始时间
	public static Date getSomeDay(Date date,int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, add);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	//获取某天的开始时间
	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/*
	 * 格式化保留两位小数 后面舍去
	 */
	public static BigDecimal formatBigDecimal(BigDecimal decimal) {
		//DecimalFormat df = new DecimalFormat("#.##");保留两位小数
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.CEILING);
		return new BigDecimal(df.format(decimal));
	}
	
	/**
	 * 随机生成len位数字验证码
	 * @param 验证码位数
	 * @return
	 */
	public static String randomIdentifyingCode(int len){
		String t = "0123456789";
		String n = "";
		for (int r = 0; len > r; ++r) {
			n += t.charAt(new Random().nextInt(t.length()));
		}
		return n;
	}
	
	public static String getImageURL(String imagesUrl){
		String prefix = "http://zhaoyuan.micro-silver.cn/";
		if(!imagesUrl.contains("attachment")){
			prefix += "attachment";
		}
		return prefix+imagesUrl;
	}
	/** 正则表达
     * 手机号码由11位数字组成，
     * 匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
	public static boolean isNumLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,1,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
