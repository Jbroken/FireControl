package com.fire.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DivisionUtil {
	/**
	 * 
	 * @param 两数做除法运算 a/b，返回保留小数点后两位数的百分数
	 * @return 百分数 s
	 */
	public static String Division(int a,int b){
		
		float num = (float)a/b;
		//获取格式化对象
		NumberFormat nt = NumberFormat.getPercentInstance();
		//设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(2);
		
		String s = nt.format(num);
		
		return s;
	}
	/**
	 * 
	 * @param a 被除数
	 * @param b 除数
	 * @return float
	 */
	public static String ReturnDecimals(int a,int b){
		float s = (float)a/b;
		DecimalFormat df = new DecimalFormat("0.00");
		String num = df.format(s);
		return num;
	}
}
