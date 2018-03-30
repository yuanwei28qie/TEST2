package com.microsilver.mrcard.scheduledtask.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberFormat {
	/*
	 * 格式化保留两位小数 后面舍去
	 */
	public static BigDecimal formatBigDecimal(BigDecimal decimal){
		//DecimalFormat df = new DecimalFormat("#.##");  //保留两位小数
		DecimalFormat df = new DecimalFormat("#"); 
		df.setRoundingMode(RoundingMode.CEILING);
		return new BigDecimal(df.format(decimal));
	}	
}
